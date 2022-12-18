
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SE {
    public String input(String Result ,String lex2){
        String lex = lex2.substring(4);
        String final_list [] = new String[lex.length()];
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
        // Print out each operation on a separate line
        int i = 0 ;
        for (String operation : operations) {
            final_list[i]=operation;
            i++;
        }
        for(i=0;i< final_list.length;i++){
            String temp = final_list[i];
           if (temp == null){}
           else{
               if(temp.equals("id2") || temp.equals("id3") || temp.equals("id4")){}
               else if(temp.equals("3.14")){}
               else if(temp.equals("+") || temp.equals("-") || temp.equals("*")|| temp.equals("\\")){}
               else{
                   Result+="\n           "+"int to float ("+temp+")";
               }
           }
        }
        return Result;
    }
}
