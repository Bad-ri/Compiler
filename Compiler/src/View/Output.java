
package View;

import Controller.*;

import javax.swing.JFrame;

public class Output extends JFrame{
    public void RUN(String User_Input){
        LX x = new LX();
        SY Y = new SY();
        ICG G = new ICG();
        String z = " ";
        z = x.Lexical(User_Input);
        System.out.println("----------------------------");
        System.out.println("Lexical Analyzer");
        System.out.println("----------------------------");
        System.out.println(z);
        String xx = koko(z);
        System.out.println("----------------------------");
        System.out.println("Syntex Analyzer");
        System.out.println("----------------------------");
        System.out.println(xx);
        String yy = toto(xx,z);
        System.out.println("----------------------------");
        System.out.println("Semantic Analyzer");
        System.out.println("----------------------------");
        System.out.println(yy);
        String vv = gogo(yy,z);
        System.out.println("----------------------------");
        System.out.println("ICG Analyzer");
        System.out.println("----------------------------");
        System.out.println(vv);
        String zz = soso(yy,z);
        System.out.println("----------------------------");
        System.out.println("Optemizer Analyzer");
        System.out.println("----------------------------");
        System.out.println(zz);
        String tt = roro(z);
        System.out.println("----------------------------");
        System.out.println("Code Generation");
        System.out.println("----------------------------");
        System.out.println(tt);
    }
    public String koko(String z){
        String input = z;
        String result = "";
        SY call = new SY();
        result = call.input(input) ;
        //Y.input(z);
        return result;
    }
    public String toto(String z, String s){
        String input = z;
        String result = "";
        SE call = new SE();
        result = call.input(input,s) ;
        //Y.input(z);
        return result;
    }

    private String gogo(String z,String lex) {
        String input = z;
        String result = "";
        ICG call = new ICG();
        result = call.input(input,lex) ;
        //Y.input(z);
        return result;
    }
    private String soso(String z , String lex) {
        String input = z;
        String result = "";
        OP call = new OP();
        result = call.input(input,lex) ;
        //Y.input(z);
        return result;
    }
    private String roro(String z) {
        String input = z;
        String result = "";
        CG call = new CG();
        result = call.input(input) ;
        return result;
    }

}
