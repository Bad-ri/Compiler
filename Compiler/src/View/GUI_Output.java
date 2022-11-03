
package View;

import Controller.LX;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUI_Output extends JFrame{
    public void RUN(String User_Input){
        LX x = new LX();
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
    
    
    
    //add compnants to the panel
        LXPanel.add(Output);
        LXPanel.add(OutputFiled);
        
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
    
}
