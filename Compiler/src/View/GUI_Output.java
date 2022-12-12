
package View;

import Controller.ICG;
import Controller.LX;
import Controller.OP;
import Controller.SE;
import Controller.SY;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUI_Output extends JFrame{
    public void RUN(String User_Input){
        LX x = new LX();
        SY Y = new SY();
        ICG G = new ICG();
        String z = " ";
        z = x.Lexical(User_Input);

        JLabel Output = new JLabel(" ");
        JTextField OutputFiled = new JTextField(15);
        OutputFiled.setOpaque(false);
        Output.setPreferredSize(new Dimension(250, 100));
        OutputFiled.setFont(new Font("Verdana", Font.PLAIN, 20));
        OutputFiled.setText(z);

        JPanel CodePanel = new JPanel();
        JPanel MainPanel = new JPanel();
        JPanel LXPanel = new JPanel();
        JPanel SYPanel = new JPanel();
        JPanel SEPanel = new JPanel();
        JPanel ICGPanel = new JPanel();
        JPanel OPPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(2, 1));

        // border decleration and intitialization
        TitledBorder border = new TitledBorder("Lexical Analysar");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.DARK_GRAY);
        border.setTitleFont(new Font("Verdana", Font.HANGING_BASELINE, 30));
        LXPanel.setBorder(border);
        TitledBorder border1 = new TitledBorder("Syntex Analysar");
        border1.setTitleJustification(TitledBorder.CENTER);
        border1.setTitlePosition(TitledBorder.TOP);
        border1.setTitleColor(Color.DARK_GRAY);
        border1.setTitleFont(new Font("Verdana", Font.HANGING_BASELINE, 30));
        SYPanel.setBorder(border1);
        TitledBorder border2 = new TitledBorder("Semantic Analysar");
        border2.setTitleJustification(TitledBorder.CENTER);
        border2.setTitlePosition(TitledBorder.TOP);
        border2.setTitleColor(Color.DARK_GRAY);
        border2.setTitleFont(new Font("Verdana", Font.HANGING_BASELINE, 30));
        SEPanel.setBorder(border2);
        TitledBorder border3 = new TitledBorder("ICG Analysar");
        border3.setTitleJustification(TitledBorder.CENTER);
        border3.setTitlePosition(TitledBorder.TOP);
        border3.setTitleColor(Color.DARK_GRAY);
        border3.setTitleFont(new Font("Verdana", Font.HANGING_BASELINE, 30));
        ICGPanel.setBorder(border3);
        TitledBorder border4 = new TitledBorder("Optemizer Analysar");
        border4.setTitleJustification(TitledBorder.CENTER);
        border4.setTitlePosition(TitledBorder.TOP);
        border4.setTitleColor(Color.DARK_GRAY);
        border4.setTitleFont(new Font("Verdana", Font.HANGING_BASELINE, 30));
        OPPanel.setBorder(border4);
        TitledBorder border5 = new TitledBorder("Code Generator");
        border5.setTitleJustification(TitledBorder.CENTER);
        border5.setTitlePosition(TitledBorder.TOP);
        border5.setTitleColor(Color.DARK_GRAY);
        border5.setTitleFont(new Font("Verdana", Font.HANGING_BASELINE, 30));
        CodePanel.setBorder(border5);

        String xx = koko(z);
        JTextArea Output2 = new  JTextArea(16,30);
        Output2.setOpaque(false);
        Output2.setFont(new Font("Verdana", Font.HANGING_BASELINE, 10));
        Output2.setText(xx);

        String yy = toto(z);
        JTextArea Output3 = new  JTextArea(16,30);
        Output3.setOpaque(false);
        Output3.setFont(new Font("Verdana", Font.HANGING_BASELINE, 10));
        Output3.setText(yy);

        String vv = gogo(yy);
        JTextArea Output4 = new  JTextArea(16,30);
        Output4.setOpaque(false);
        Output4.setFont(new Font("Verdana", Font.HANGING_BASELINE, 15));
        Output4.setText(vv);

        String zz = soso(yy);
        JTextArea Output5 = new  JTextArea(16,30);
        Output5.setOpaque(false);
        Output5.setFont(new Font("Verdana", Font.HANGING_BASELINE, 15));
        Output5.setText(zz);

        String tt = roro(yy);
        JTextArea Output6 = new  JTextArea(16,30);
        Output6.setOpaque(false);
        Output6.setFont(new Font("Verdana", Font.HANGING_BASELINE, 15));
        Output6.setText(zz);

        //add compnants to the panel
        LXPanel.add(Output);
        LXPanel.add(OutputFiled);
        SYPanel.add(Output2);
        SEPanel.add(Output3);
        ICGPanel.add(Output4);
        OPPanel.add(Output5);
        CodePanel.add(Output6);


        //add compnants to the main panel
        MainPanel.add(LXPanel);
        MainPanel.add(SYPanel);
        MainPanel.add(SEPanel);
        MainPanel.add(ICGPanel);
        MainPanel.add(OPPanel);
        MainPanel.add(CodePanel);


        this.add(MainPanel);
        this.setVisible(true);
        this.setTitle("Output");
        this.setSize(1200, 700);
        this.setLocation(90,30);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
    public String koko(String z){
        String input = z;
        String result = "";
        SY call = new SY();
        result = call.input(input) ;
        //Y.input(z);
        return result;
    }
    public String toto(String z){
        String input = z;
        String result = "";
        SE call = new SE();
        result = call.input(input) ;
        //Y.input(z);
        return result;
    }

    private String gogo(String z) {
        String input = z;
        String result = "";
        ICG call = new ICG();
        result = call.input(input) ;
        //Y.input(z);
        return result;
    }

    private String soso(String z) {
        String input = z;
        String result = "";
        OP call = new OP();
        result = call.input(input) ;
        //Y.input(z);
        return result;
    }
    private String roro(String z) {
        String input = z;
        String result = "";
        OP call = new OP();
        result = call.input(input) ;
        return result;
    }

}
