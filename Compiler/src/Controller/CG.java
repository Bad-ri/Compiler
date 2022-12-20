package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CG {
    public String input(String lex2){
        String Result = "" ;
        int counter = 1 ;
        String lex = lex2.substring(4);
        String [] final_list = new String[7];
        String tempo = "" ;
        int count = 0 ;
        for (int i = 0 ; i < lex.length(); i++){
            if(i==lex.length()-1){
                tempo = lex.substring(i);
            }
            else{
                tempo = lex.substring(i,i+1);
            }
            if("+".equals(tempo)||"-".equals(tempo)||"*".equals(tempo)||"\\".equals(tempo)) {
                count++;
            }
        }
        if(count==3){
            List<String> operations = new ArrayList<>();
            StringBuilder currentTerm = new StringBuilder();
            for (int i = 0; i < lex.length(); i++) {
                char c = lex.charAt(i);
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    // If we've reached an operator, add the current term to the list of
                    // operations and reset the current term
                    operations.add(currentTerm.toString());
                    currentTerm = new StringBuilder();
                    operations.add(Character.toString(c));
                } else {
                    // If we haven't reached an operator, append the current character to
                    // the current term
                    currentTerm.append(c);
                }
            }
            // Don't forget to add the last term to the list of operations
            operations.add(currentTerm.toString());
            int g = 0 ;
            for (String operation : operations) {
                final_list[g]=operation;
                g++;
            }
            //operations
            for(int i = 0 ; i<final_list.length;i++){
                String temp = final_list[i];
                if (temp == null){}
                else{
                    Result+="            MULF R2"+final_list[0]+" , "+final_list[2]+"\n";
                    Result+="            MULF R1"+final_list[4]+" , "+final_list[6]+"\n";
                    Result+="            ADDF R1"+"R1"+" , "+"R2"+"\n";
                    Result+="            STF ID1"+"R1"+"\n";
                }
            }
            return Result;
        }
       return Result ;
    }
}
