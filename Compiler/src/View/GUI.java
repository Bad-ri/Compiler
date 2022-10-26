
package View;

import Controller.Calculator;
import com.sun.jdi.Value;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GUI extends JFrame {
    public void Frame(){
        Calculator x = new Calculator();
        
        JButton Run = new JButton("Generate Lexical Analyser");
        JButton Clear = new JButton("Clear text Area");
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.setBounds(100, 110, 90, 25);
        Clear.setForeground(Color.WHITE);
        Clear.setBackground(Color.BLACK);
        Clear.setFont(new Font("Verdana", Font.PLAIN, 15));
        Run.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Run.setBounds(100, 110, 90, 25);
        Run.setForeground(Color.WHITE);
        Run.setBackground(Color.BLACK);
        Run.setFont(new Font("Verdana", Font.PLAIN, 15));
        
      JLabel Separator = new JLabel(" ");
      JLabel Input = new JLabel("Enter The Equation");
      JTextField InputFiled = new JTextField(15);
      InputFiled.setOpaque(false);
      JLabel Output = new JLabel("The Output");
      JTextField OutputFiled = new JTextField(15);
      OutputFiled.setOpaque(false);

      
      Separator.setFont(new Font("Verdana", Font.PLAIN, 20));
      Input.setVerticalAlignment(JLabel.CENTER);
      Input.setFont(new Font("Verdana", Font.PLAIN, 20));
      Input.setPreferredSize(new Dimension(250, 100));
      Input.setForeground(new Color(120, 90, 40));
      Input.setBackground(new Color(100, 20, 70));
      Input.setVerticalAlignment(JLabel.CENTER);
      Output.setFont(new Font("Verdana", Font.PLAIN, 20));
      Output.setPreferredSize(new Dimension(250, 100));
      Output.setForeground(new Color(120, 90, 40));
      Output.setBackground(new Color(100, 20, 70)); 
      InputFiled.setFont(new Font("Verdana", Font.PLAIN, 20));
      OutputFiled.setFont(new Font("Verdana", Font.PLAIN, 20));
      
      Run.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
      String y = InputFiled.getText();
      String z = "";
      z = x.Calc(y);
      OutputFiled.setText(z);
}});
       Clear.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
      InputFiled.setText(" ");
      OutputFiled.setText(" ");
}});
    
 
       JPanel Panel = new JPanel();
       BoxLayout boxlayout = new BoxLayout(Panel, BoxLayout.Y_AXIS);
        Panel.setLayout(boxlayout);
         Panel.setBorder(new EmptyBorder(new Insets(20, 100, 50, 100)));      

        JPanel MainPanel = new JPanel();
        JPanel BorderPanel = new JPanel();
        JPanel ButtonPanel = new JPanel();
        JPanel InputPanel = new JPanel();
        JPanel InfoPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout());
        ButtonPanel.setLayout(new FlowLayout());
        BorderPanel.setLayout(new FlowLayout());
        //InputPanel.setLayout(new GridLayout(5,1));
        
    TitledBorder border = new TitledBorder("Lexical Analysar");
    border.setTitleJustification(TitledBorder.CENTER);
    border.setTitlePosition(TitledBorder.TOP);
    border.setTitleColor(Color.DARK_GRAY);
    border.setTitleFont(new Font("Verdana", Font.HANGING_BASELINE, 20));
    Panel.setBorder(border);
   
        Panel.add(Input);
        Panel.add(InputFiled);
        Panel.add(Output);
        Panel.add(OutputFiled);
        Panel.add(Separator);
        BorderPanel.add(Panel);

        ButtonPanel.add(Run);
        ButtonPanel.add(Clear);
        MainPanel.add(ButtonPanel, BorderLayout.SOUTH);
        MainPanel.add(BorderPanel, BorderLayout.CENTER);
        MainPanel.add(InfoPanel, BorderLayout.NORTH);

       // InfoPanel.setBackground(new java.awt.Color(51, 204, 0));
        this.add(MainPanel);
        this.setVisible(true);
        this.setTitle("Compiler");
        this.setSize(500, 420);
        this.setLocation(320,130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
