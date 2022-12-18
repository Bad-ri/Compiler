
package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LX {
    public static String Lexical(String y){
        String Target ="ID"; // replacment of the character and string
        String Target2 ="x*x"; // replacment of character multiply by character
        String Result =""; // variable used in the replacment section
        String FinalResult =""; // final result that will be returned
        String x = "";
        String z = "";
        int Counter = 0 ;

        // if string made from 3 or more characters was found replace it with one character
        Pattern pattern1 = Pattern.compile("pi", Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(y);
        while(matcher1.find()) {
            Result = matcher1.replaceAll("3.14");
        }
        if(Result==""){
            Result=y;
        }
        // reduce //
        //2*3.14+x
        String f = Result ;
        String op = "";
        //(\d(\d.\d\d)r)
        Pattern pattern30 = Pattern.compile("\\d[*|+|-|\\\\](\\d.\\d\\d)", Pattern.CASE_INSENSITIVE);
        Matcher matcher30 = pattern30.matcher(f);
        while(matcher30.find()) {
            op = f.substring(2,3);
            float ff = Integer.parseInt(op);
            ff = (float) (ff * 3.14);
            Result = f.substring(0,2)+ff+f.substring(8);
        }
        Pattern pattern40 = Pattern.compile("(\\d(\\d.\\d\\d)r)", Pattern.CASE_INSENSITIVE);
        Matcher matcher40 = pattern40.matcher(f);
        while(matcher40.find()) {
            op = f.substring(2,3);
            float ff = Integer.parseInt(op);
            ff = (float) (ff * 3.14);
            Result = f.substring(0,2)+ff+"*"+f.substring(7);
        }

        // if string made from 2 characters was found replace it with two characters separated with multiplication symbol in the middle   
        Pattern pattern2 = Pattern.compile("[a-z||A-Z][a-z||A-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(Result);
        while(matcher2.find()) {
            Result = matcher2.replaceAll(Target2);
        }
        /*
        Pattern pattern3 = Pattern.compile("[p]+[o]+[w]+[(]+[\\d][,][\\d][)]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(Result);
        while(matcher3.find()) {
           Matcher d = matcher3 ;
           Result = matcher3.replaceAll("k");  
        }
        */

        // finaly replace all characters with the target (id)    
        Pattern pattern = Pattern.compile("[a-z||A-Z]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(Result);
        while(matcher.find()) {
            Result = matcher.replaceAll(Target);
        }

        // replace the string(ID) with (id) with its count          
        for(int i = 0 ; i<Result.length() ; i++){

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
                // Error handel when found (_)
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

//  REGEX
// "[a-z||A-Z]*[_||.]*[a-z||A-Z]+"  Read any String and any alpha
// "\\d"  Read any Number
// "[+||-||*||\\]"  Read any Symbol
// "[s]+[q]+[r]+[(]+[\d][,][\d][)]+" Read sqr
// "[p]+[o]+[w]+[(]+[\d][,][\d][)]+" Read pow
// "[p]+[i]+" Read pi 