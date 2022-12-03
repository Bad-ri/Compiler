
package Controller;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SE {
    
    public String input(String z){
    String Result = "";
    String input = "";  
    String lex = "";
    input = z ;
    String temp = "";
    String test1 = "";
    String test2 = "";
    String symbo = "";
    Result += "id1 ---------------> = " + " \n ";
    Result += "                           \\" + " \n ";
    
    //System.out.println("id1 -------> = ");
    //System.out.println("               \\");
    //System.out.println(input);

    lex = input.substring(4);
    Stack stack = new Stack();

    for(int i = 0 ; i < lex.length() ; i++){
        if(i==lex.length()-1){
            temp = lex.substring(i);
        }
        else{
            temp = lex.substring(i,i+1);
        } 
        if("*".equals(temp)){
            test1= lex.substring(i-3,i-2);
                if("i".equals(test1)){
                   test1= lex.substring(i-3,i);
                }
                else if(".".equals(test1)){
                   test1= lex.substring(i+1,i+5);
                }
                else{
                   test1= lex.substring(i-1,i);
                }
                test2= lex.substring(i+1,i+2);
                if("i".equals(test2)){
                   test2= lex.substring(i+1,i+4);
                }
                else if(".".equals(lex.substring(i+2,i+3))){
                   test2= lex.substring(i+1,i+5);
                }
                else{
                   test2= lex.substring(i+1,i+2);
                }     
        stack.push(test1);
        stack.push("*");
        stack.push(test2);
        lex = lex.substring(0,i-1) + lex.substring(i+2);
        }
    }	
    for(int i = 0 ; i < lex.length() ; i++){
        if(i==lex.length()-1){
            temp = lex.substring(i);
        }
        else{
            temp = lex.substring(i,i+1);
        } 
        if("+".equals(temp)){
          stack.push("+");  
         // if(lex.substring(i-1,i)==""){}
          
            test1= input.substring(i-3,i-2);
                if("i".equals(test1)){
                   test1= lex.substring(i-3,i);
                }
                else{
                   test1= lex.substring(i-1,i);
                }
          
    
          stack.push(test1);
       
        lex = lex.substring(i+1);
        }
    }	
     for(int i = 0 ; i < lex.length() ; i++){
        if(i==lex.length()-1){
            temp = lex.substring(i);
        }
        else{
            temp = lex.substring(i,i+1);
        } 
        if("-".equals(temp)){
            
        stack.push("-");  
         test1= lex.substring(i+1,i+2);
         
                if("i".equals(test1)){
                   test1= lex.substring(i+1);
                }
                else{
                   test1= lex.substring(i+1);
                }
                
        stack.push(test1);       
        //lex = "";
        }
    }	
     boolean type;
     boolean type2;

     while (!stack.empty()){
         type = false ;
         type2 = false ;
         String V = (String) stack.pop();
         String S = (String) stack.pop();
         Result += "     	         " + S + " \n ";
         Result += "                         /" +"--"+ "\\" + " \n ";
         if(stack.size()==1){
         String V2 = (String) stack.pop();   
        Pattern pattern1 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(V);
        while(matcher1.find()) {
           type = true ;  
        }   
        Pattern pattern2 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(V2);
        while(matcher2.find()) {
           //type2 = true ;  
        }   
         Result += "     	     "+ V2+ "   " + V + " \n ";
         }
         else{
         Result += "     	    " + V + "  | " + " \n ";
         }
         if(type){
              if(type2){
              Result += "     	         int to float " + "     int to float"+" \n ";
              }
         else{
              Result += "  int to float " + " \n ";
              } 
         } 
         else if(type2){
         Result += "     	                          int to float " + " \n ";
         } 
         
         
     }
     //Result += "     	           " + lex;  
     /*
     Result = "mohamed \n mohamed";
        return Result;
     */
     return Result;
    }  
    
}
