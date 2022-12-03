
package Controller;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICG {

     public String input(String z){
    String Result = "";
    String input = "";  
    String lex = "";
    input = z ;   
    lex = input.substring(4);
    //x=z+2*3.14
    
    Result += "             T1= int to float(" + lex.substring(4,5) + ")"+" \n ";
    Result += "             T2=#T1 * " + lex.substring(6)+" \n ";
    Result += "             T3=T2+" + lex.substring(0, 3)+" \n ";
    Result += "             Id1=T3";

     return Result;
    }  
    
}
