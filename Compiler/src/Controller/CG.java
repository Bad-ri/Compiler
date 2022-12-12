package Controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CG {
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
            if(j==2){
                String now = new_list[j-1] ;
                if(now.contains("*")){
                    now="*";
                }
                else if(now.contains("\\")){
                    now="\\";
                }
                boolean flag = false;
                int onetime = 0 ;
                Result+="            T1 = ";
                String parts[] = new_list[j].split("\\s");
                for(String part: parts) {
                    //String semi = part.replaceAll("\\s", "");
                    if(part.equals("")){}
                    else{
                        Result+=part;
                        flag = true ;
                        onetime++;
                    }
                    if(flag&&onetime==1){
                        Result+=now;
                        flag=false;
                        onetime++;
                    }
                }
                Result+="\n";
            }
            else if(j==1){
                String now = new_list[j] ;
                Matcher matcher;
                Pattern pattern1 = Pattern.compile("[*|\\\\\\\\|+|-]", Pattern.CASE_INSENSITIVE);
                matcher = pattern1.matcher(now);
                while(matcher.find()) {
                    answear = matcher.replaceAll("");
                }
                String symbol = new_list[j-1].replaceAll("\\s", "");
                String exp = answear.replaceAll("\\s", "");
                Result+="            id1 = "+exp+symbol+" T1"+"\n";
            }


        }
        return Result;
    }

}
