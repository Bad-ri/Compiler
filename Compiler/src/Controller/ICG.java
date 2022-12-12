
package Controller;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICG {

     public String input(String z){
         String answear = "";
    int i = 0 ;
    String Result = " ";
    String result = " " ;
    int linat =0;
    String[] list = new String[11];
    String[] new_list = new String[5];
    int count = 0 ;
    Scanner scanner = new Scanner(z);
    while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    list[i]=line;
    i++;
    }
    scanner.close();
     
    for(int j=0;j<list.length;j++){
        switch(j){
            case(2):
             new_list[count]=list[j];
             count++;
            break;
            case(4):
             new_list[count]=list[j];
             count++;
            break;
            case(6):
             new_list[count]=list[j];
             count++;
            break;
            case(8):
             new_list[count]=list[j];
             count++;
            break;
            case(9):
             new_list[count]=list[j];
             count++;
            break;
        }        
}//remove null from the list
    for(int j = 0 ; j < new_list.length ; j++){
        String temp = new_list[j];
        if(temp==null){
        new_list[j]="";
        } 
    }
    for(int j = 4 ; j >= 0 ; j--){
        String temp = new_list[j];
         if(temp.contains("int")){
             Result+=new_list[j]+"\n";
         }
         else if(j==2){
            Result+=new_list[j];
            String now = new_list[j-1] ;
            if(now.contains("*")){
            Result+="*"+"\n";
         }
            else if(now.contains("\\")){
            Result+="\\"+"\n";
         }    
         }
         else if(j==1){
            String now = new_list[j] ;
            Matcher matcher;
        Pattern pattern1 = Pattern.compile("[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern1.matcher(now);
        while(matcher.find()) {
            answear = matcher.replaceAll("");
         }   
        Result+=answear+new_list[j-1]+"\n";
         }       
        
        
}

    /*
    if(lines[i].startsWith("i")){
        lines[i]="";
    }
    */
    
/*
    Scanner scanner = new Scanner(z);
    while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    Result += line+"\n";
    }
    scanner.close();
    */
    
    return Result;
    }  
}
