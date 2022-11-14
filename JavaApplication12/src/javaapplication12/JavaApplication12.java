
package javaapplication12;

import java.util.Stack;

public class JavaApplication12 {

    public static void main(String[] args) {
        String input = "id1=id2+5*id3-id4";
                String lex = "";
    String temp = "";
    String test1 = "";
    String test2 = "";
    String symbo = "";
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
                else{
                   test1= lex.substring(i-1,i);
                }
                test2= lex.substring(i+1,i+2);
                if("i".equals(test2)){
                   test2= lex.substring(i+1,i+4);
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
                   test1= lex.substring(i);
                }
                
        stack.push(test1);       
        lex = "";
        }
    }	
     while (!stack.empty()){
      System.out.println(stack.pop());
     }
     
    }
    
}
