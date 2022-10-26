
package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static String Calc(String y){
        String Target ="ID";
        String Result ="";
        String FinalResult ="";
        String x = "";
        String z = "";
        int Counter = 0 ;
    Pattern patterntest = Pattern.compile("[0-9][a-z||A-Z]*", Pattern.CASE_INSENSITIVE);
    Matcher matchertest = patterntest.matcher(y);
   while(matchertest.find()) {
           FinalResult="Syntax Error";  
           break;
        }
   
    Pattern pattern = Pattern.compile("[a-z||A-Z]*[_||.]*[a-z||A-Z]+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(y);
   while(matcher.find()) {
           Result = matcher.replaceAll(Target);  
        }
   for(int i = 0 ; i<Result.length() ; i++){ 
       if(FinalResult=="Syntax Error"){
           break;
       }
       if(i+2 >= Result.length()){
          x = Result.substring(i, Result.length());
       }
       else{
          x = Result.substring(i, i+2); 
       }
       if(x.equals(Target)){
          Counter++;
          x="id"+Counter;
         FinalResult+=x;       
       }
       else{
         z=x.substring(1);
         if(z.equals("I")||z.equals("D")){
         }
         else if(z.equals("_")){
         FinalResult="Syntax Error"; 
         break;
       }
        
         
         else{
           FinalResult+=z;      
          }
       }  
   }
        return FinalResult;
   
    }
}
// "[a-z||A-Z]*[_||.]*[a-z||A-Z]+"  Read any String and any alpha
// "\\d"  Read any Number
// "[+||-||*||\\]"  Read any Symbol