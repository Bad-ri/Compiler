
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SY {

    public String input(String z){
        String Result = " ";
        String input = "";
        String lex = "";
        input = z ;
        String temp = "";
        int addop = 0 ;
        int mulop = 0 ;
    /*
    String test1 = "";
    String test2 = "";
    String symbo = "";
    */
        Result += "id1 ---------------> = " + " \n ";
        Result += "                           \\" + " \n ";
        // new feature
        lex = input.substring(4);
        String lex2 =" "+lex;
        for(int i = 0 ; i < lex.length() ; i++){
            if(i==lex.length()-1){
                temp = lex.substring(i);
            }
            else{
                temp = lex.substring(i,i+1);
            }
            if("+".equals(temp)||"-".equals(temp)){
                addop++;
            }
            else if ("*".equals(temp)||"\\".equals(temp)){
                mulop++;
            }
        }
        // which equation ? 3 or 4
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
            //call
            Result += FOP(lex,final_list);
        }
       else if (count == 1){
            Result += "     	     " + lex.substring(4,5) + " \n ";
            Result += "                        /" +"--"+ "\\" + " \n ";
            Result += "               "+ lex.substring(0,4)+ "   " + lex.substring(5) + " \n ";

        }
       else{
           if(addop==mulop){
               for(int i = 0 ; i < lex.length() ; i++){
                   if(i==lex.length()-1){
                       temp = lex.substring(i);
                   }
                   else{
                       temp = lex.substring(i,i+1);
                   }
                   if("+".equals(temp)||"-".equals(temp)){
                       Result += RHS(lex,lex2);
                       break;
                   }
                   else if ("*".equals(temp)||"\\".equals(temp)){
                       Result += LHS(lex,lex2);
                       break;
                   }
               }
           }
           else if (addop>mulop){
               Result += NOP(lex,lex2);
           }
       }

        return Result;
    }
    public String RHS(String lex,String lex2){
        String Result = "";
        Matcher matcher;
        //x=x+5*pi
        //id2-5\id4
        //id2-5\5
        Pattern pattern1 = Pattern.compile("(id\\d)[+|-](\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern1.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(3,4) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,3)+ "   " + lex.substring(5,6) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,5)+ "   " + lex.substring(6) + " \n ";
            return Result;
        }
        //id2-3.14\4
        //id2-3.14\id4
        //id2-3.14\3.14
        Pattern pattern2 = Pattern.compile("(id\\d)[+|-](\\d.\\d\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern2.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(3,4) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,3)+ "   " + lex.substring(8,9) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,8)+ "   " + lex.substring(9) + " \n ";
            return Result;
        }
        //id2-id3*5
        //id2-id3\3.14
        //id2-id3\id4
        Pattern pattern3 = Pattern.compile("(id\\d)[+|-](id\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern3.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(3,4) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,3)+ "   " + lex.substring(7,8) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,7)+ "   " + lex.substring(8) + " \n ";
            return Result;
        }
        //2+5*3.14
        //2-5\id4
        //2-5\4
        Pattern pattern4 = Pattern.compile("(\\s\\d)[+|-](\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern4.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(1,2) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,1)+ "   " + lex.substring(3,4) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,3)+ "   " + lex.substring(4) + " \n ";
            return Result;
        }
        //2-3.14\5
        //2-3.14\id5
        //2-3.14\3.14
        Pattern pattern5 = Pattern.compile("(\\s\\d)[+|-](\\d.\\d\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern5.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(1,2) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,1)+ "   " + lex.substring(6,7) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,6)+ "   " + lex.substring(7) + " \n ";
            return Result;
        }
        //2-id3\3.14
        //2-id3\5
        //2-id3\id7
        Pattern pattern6 = Pattern.compile("(\\s\\d)[+|-](id\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern6.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(1,2) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,1)+ "   " + lex.substring(5,6) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,5)+ "   " + lex.substring(6) + " \n ";
            return Result;
        }
        //3.14+5*3.14
        //3.14-5\id4
        //3.14-5\5
        Pattern pattern7 = Pattern.compile("(\\d.\\d\\d)[+|-](\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern7.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(4,5) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,4)+ "   " + lex.substring(6,7) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,6)+ "   " + lex.substring(7) + " \n ";
            return Result;
        }

        //3.14 -3.14\5
        //3.14 -3.14\id4
        //3.14 -3.14\3.14
        Pattern pattern8 = Pattern.compile("(\\d.\\d\\d)[+|-](\\d.\\d\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern8.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(4,5) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,4)+ "   " + lex.substring(9,10) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,9)+ "   " + lex.substring(10) + " \n ";
            return Result;
        }
        //3.14 -id3\5
        //3.14 -id3\3.14
        //3.14 -id3\id4
        Pattern pattern9 = Pattern.compile("(\\d.\\d\\d)[+|-](id\\d)[*|\\\\]", Pattern.CASE_INSENSITIVE);
        matcher = pattern9.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(4,5) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,4)+ "   " + lex.substring(8,9) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,8)+ "   " + lex.substring(9) + " \n ";
            return Result;
        }
        return Result;
    }
    public String LHS(String lex,String lex2){
        String Result = "";
        Matcher matcher;
        //x=x+5*pi
        //id2-5\id4
        //id2-5\5
        Pattern pattern1 = Pattern.compile("(id\\d)[*|\\\\](\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern1.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(5,6) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(6)+ "   " + lex.substring(3,4) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,5)+ "   " + lex.substring(0,3) + " \n ";
            return Result;
        }
        //id2-3.14\4
        //id2-3.14\id4
        //id2-3.14\3.14
        Pattern pattern2 = Pattern.compile("(id\\d)[*|\\\\](\\d.\\d\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern2.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(8,9) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(9)+ "   " + lex.substring(3,4) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,8)+ "   " + lex.substring(0,3) + " \n ";
            return Result;
        }
        //id2-id3*5
        //id2-id3\3.14
        //id2-id3\id4
        Pattern pattern3 = Pattern.compile("(id\\d)[*|\\\\](id\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern3.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(7,8) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(8)+ "   " + lex.substring(3,4) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,7)+ "   " + lex.substring(0,3) + " \n ";
            return Result;
        }
        //2+5*3.14
        //2-5\id4
        //2-5\4
        Pattern pattern4 = Pattern.compile("(\\s\\d)[*|\\\\](\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern4.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(3,4) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(4)+ "   " + lex.substring(1,2) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,3)+ "   " + lex.substring(0,1) + " \n ";
            return Result;
        }
        //2-3.14\5
        //2-3.14\id5
        //2-3.14\3.14
        Pattern pattern5 = Pattern.compile("(\\s\\d)[*|\\\\](\\d.\\d\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern5.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(6,7) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(7)+ "   " + lex.substring(1,2) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,6)+ "   " + lex.substring(0,1) + " \n ";
            return Result;
        }
        //2-id3\3.14
        //2-id3\5
        //2-id3\id7
        Pattern pattern6 = Pattern.compile("(\\s\\d)[*|\\\\](id\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern6.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(5,6) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(6)+ "   " + lex.substring(1,2) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,5)+ "   " + lex.substring(0,1) + " \n ";
            return Result;
        }
        //3.14+5*3.14
        //3.14-5\id4
        //3.14-5\5
        Pattern pattern7 = Pattern.compile("(\\d.\\d\\d)[*|\\\\](\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern7.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(6,7) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(7)+ "   " + lex.substring(4,5) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,6)+ "   " + lex.substring(0,4) + " \n ";
            return Result;
        }

        //3.14 -3.14\5
        //3.14 -3.14\id4
        //3.14 -3.14\3.14
        Pattern pattern8 = Pattern.compile("(\\d.\\d\\d)[*|\\\\](\\d.\\d\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern8.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(9,10) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(10)+ "   " + lex.substring(4,5) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,9)+ "   " + lex.substring(0,4) + " \n ";
            return Result;
        }
        //3.14 -id3\5
        //3.14 -id3\3.14
        //3.14 -id3\id4
        Pattern pattern9 = Pattern.compile("(\\d.\\d\\d)[*|\\\\](id\\d)[+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern9.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(8,9) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(9)+ "   " + lex.substring(4,5) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,8)+ "   " + lex.substring(0,4) + " \n ";
            return Result;
        }
        return Result;
    }
    public String NOP(String lex,String lex2){
        String Result = "";
        Matcher matcher;
        //x=x+5*pi
        //id2-5\id4
        //id2-5\5
        Pattern pattern1 = Pattern.compile("(id\\d)[*|\\\\|+|-](\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern1.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(5,6) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(6)+ "   " + lex.substring(3,4) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,5)+ "   " + lex.substring(0,3) + " \n ";
            return Result;
        }
        //id2-3.14\4
        //id2-3.14\id4
        //id2-3.14\3.14
        Pattern pattern2 = Pattern.compile("(id\\d)[*|\\\\|+|-](\\d.\\d\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern2.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(8,9) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(9)+ "   " + lex.substring(3,4) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,8)+ "   " + lex.substring(0,3) + " \n ";
            return Result;
        }
        //id2-id3*5
        //id2-id3\3.14
        //id2-id3\id4
        Pattern pattern3 = Pattern.compile("(id\\d)[*|\\\\|+|-](id\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern3.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(7,8) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(8)+ "   " + lex.substring(3,4) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,7)+ "   " + lex.substring(0,3) + " \n ";
            return Result;
        }
        //2+5*3.14
        //2-5\id4
        //2-5\4
        Pattern pattern4 = Pattern.compile("(\\s\\d)[*|\\\\|+|-](\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern4.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(3,4) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(4)+ "   " + lex.substring(1,2) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,3)+ "   " + lex.substring(0,1) + " \n ";
            return Result;
        }
        //2-3.14\5
        //2-3.14\id5
        //2-3.14\3.14
        Pattern pattern5 = Pattern.compile("(\\s\\d)[*|\\\\|+|-](\\d.\\d\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern5.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(6,7) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(7)+ "   " + lex.substring(1,2) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,6)+ "   " + lex.substring(0,1) + " \n ";
            return Result;
        }
        //2-id3\3.14
        //2-id3\5
        //2-id3\id7
        Pattern pattern6 = Pattern.compile("(\\s\\d)[*|\\\\|+|-](id\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern6.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(5,6) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(6)+ "   " + lex.substring(1,2) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,5)+ "   " + lex.substring(0,1) + " \n ";
            return Result;
        }
        //3.14+5*3.14
        //3.14-5\id4
        //3.14-5\5
        Pattern pattern7 = Pattern.compile("(\\d.\\d\\d)[*|\\\\|+|-](\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern7.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(6,7) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(7)+ "   " + lex.substring(4,5) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,6)+ "   " + lex.substring(0,4) + " \n ";
            return Result;
        }

        //3.14 -3.14\5
        //3.14 -3.14\id4
        //3.14 -3.14\3.14
        Pattern pattern8 = Pattern.compile("(\\d.\\d\\d)[*|\\\\|+|-](\\d.\\d\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern8.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(9,10) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(10)+ "   " + lex.substring(4,5) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,9)+ "   " + lex.substring(0,4) + " \n ";
            return Result;
        }
        //3.14 -id3\5
        //3.14 -id3\3.14
        //3.14 -id3\id4
        Pattern pattern9 = Pattern.compile("(\\d.\\d\\d)[*|\\\\|+|-](id\\d)[*|\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern9.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(8,9) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(9)+ "   " + lex.substring(4,5) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,8)+ "   " + lex.substring(0,4) + " \n ";
            return Result;
        }
        return Result;
    }
    public String FOP(String lex,String list[]){
        String Result = "";
            Result += "     	         " + list[3] + " \n ";
            Result += "                         /" +"--------"+ "\\" + " \n ";
            Result += "     	  "+ list[1]+ "          " + list[5] + " \n ";
            Result += "                      /" +"--"+ "\\" +"        /" +"--"+ "\\"  + " \n ";
            Result += "                   "+ list[0]+ "  " + list[2]+"   "+ list[4]+ "  " + list[6] + " \n ";
        return Result;
    }
}
/*
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
/*
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
