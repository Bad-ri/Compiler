
package Controller;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SE {


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
        return Result;
    }  //[*|\\\\|+|-]
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
            Result += " \n    	       int to float ("+ lex.substring(4,5)+ ")   "+ " \n ";
            String last = lex.substring(6);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            String last = lex.substring(9);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            String last = lex.substring(8);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(2,3)+ ")   "+ " \n ";
            String last = lex.substring(4);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(0,1)+ ")   "+ " \n ";
            String last = lex.substring(7);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(0,1)+ ")   "+ " \n ";
            String last = lex.substring(6);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(5,6)+ ")   "+ " \n ";
            String last = lex.substring(7);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            String last = lex.substring(10);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            String last = lex.substring(9);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(4,5)+ ")   "+ " \n ";
            String last = lex.substring(6);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            String last = lex.substring(9);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            String last = lex.substring(8);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(2,3)+ ")   "+ " \n ";
            String last = lex.substring(4);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(0,1)+ ")   "+ " \n ";
            String last = lex.substring(7);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(0,1)+ ")   "+ " \n ";
            String last = lex.substring(6);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            Result += " \n    	       int to float ("+ lex.substring(5,6)+ ")   "+ " \n ";
            String last = lex.substring(7);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}


                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            String last = lex.substring(10);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
            String last = lex.substring(9);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
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
        Pattern pattern1 = Pattern.compile("(id\\d)[*|\\\\\\\\|+|-](\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern1.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(3,4) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,3)+ "   " + lex.substring(5,6) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,5)+ "   " + lex.substring(6) + " \n ";
            Result += " \n    	       int to float ("+ lex.substring(4,5)+ ")   "+ " \n ";
            String last = lex.substring(6);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }
        //id2-3.14\4
        //id2-3.14\id4
        //id2-3.14\3.14
        Pattern pattern2 = Pattern.compile("(id\\d)[*|\\\\\\\\|+|-](\\d.\\d\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern2.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(3,4) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,3)+ "   " + lex.substring(8,9) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,8)+ "   " + lex.substring(9) + " \n ";
            String last = lex.substring(9);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }
        //id2-id3*5
        //id2-id3\3.14
        //id2-id3\id4
        Pattern pattern3 = Pattern.compile("(id\\d)[*|\\\\\\\\|+|-](id\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern3.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(3,4) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,3)+ "   " + lex.substring(7,8) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(4,7)+ "   " + lex.substring(8) + " \n ";
            String last = lex.substring(8);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }
        //2+5*3.14
        //2-5\id4
        //2-5\4
        Pattern pattern4 = Pattern.compile("(\\s\\d)[*|\\\\\\\\|+|-](\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern4.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(1,2) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,1)+ "   " + lex.substring(3,4) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,3)+ "   " + lex.substring(4) + " \n ";
            Result += " \n    	       int to float ("+ lex.substring(2,3)+ ")   "+ " \n ";
            String last = lex.substring(4);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}


                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }
        //2-3.14\5
        //2-3.14\id5
        //2-3.14\3.14
        Pattern pattern5 = Pattern.compile("(\\s\\d)[*|\\\\\\\\|+|-](\\d.\\d\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern5.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(1,2) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,1)+ "   " + lex.substring(6,7) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,6)+ "   " + lex.substring(7) + " \n ";
            Result += " \n    	       int to float ("+ lex.substring(0,1)+ ")   "+ " \n ";
            String last = lex.substring(7);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }
        //2-id3\3.14
        //2-id3\5
        //2-id3\id7
        Pattern pattern6 = Pattern.compile("(\\s\\d)[*|\\\\\\\\|+|-](id\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern6.matcher(lex2);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(1,2) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,1)+ "   " + lex.substring(5,6) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(2,5)+ "   " + lex.substring(6) + " \n ";
            Result += " \n    	       int to float ("+ lex.substring(0,1)+ ")   "+ " \n ";
            String last = lex.substring(6);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }
        //3.14+5*3.14
        //3.14-5\id4
        //3.14-5\5
        Pattern pattern7 = Pattern.compile("(\\d.\\d\\d)[*|\\\\\\\\|+|-](\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern7.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(4,5) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,4)+ "   " + lex.substring(6,7) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,6)+ "   " + lex.substring(7) + " \n ";
            Result += " \n    	       int to float ("+ lex.substring(5,6)+ ")   "+ " \n ";
            String last = lex.substring(7);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }

        //3.14 -3.14\5
        //3.14 -3.14\id4
        //3.14 -3.14\3.14
        Pattern pattern8 = Pattern.compile("(\\d.\\d\\d)[*|\\\\\\\\|+|-](\\d.\\d\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern8.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(4,5) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,4)+ "   " + lex.substring(9,10) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,9)+ "   " + lex.substring(10) + " \n ";
            String last = lex.substring(10);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }
        //3.14 -id3\5
        //3.14 -id3\3.14
        //3.14 -id3\id4
        Pattern pattern9 = Pattern.compile("(\\d.\\d\\d)[*|\\\\\\\\|+|-](id\\d)[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
        matcher = pattern9.matcher(lex);
        while(matcher.find()) {
            Result += "     	         " + lex.substring(4,5) + " \n ";
            Result += "                         /" +"--"+ "\\" + " \n ";
            Result += "     	     "+ lex.substring(0,4)+ "   " + lex.substring(8,9) + " \n ";
            Result += "                             /" +"--"+ "\\" + " \n ";
            Result += "     	         "+ lex.substring(5,8)+ "   " + lex.substring(9) + " \n ";
            String last = lex.substring(9);
            Pattern pattern20 = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
            matcher = pattern20.matcher(last);
            if(matcher.find()) {
                if(last.equals("3.14")){}
                else if(last.equals("id2")||last.equals("id3")){}

                else{
                    Result += "     	       int to float ("+last+ ")   "+ " \n ";
                }
            }
            return Result;
        }
        return Result;
    }
}
