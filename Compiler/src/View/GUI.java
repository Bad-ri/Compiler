
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
    public void Frame(){
    
        JButton Run = new JButton("Generate Lexical Analyser");
        JButton Clear = new JButton("Clear text Area");
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.setBounds(100, 110, 90, 25);
        Clear.setForeground(Color.WHITE);
        Clear.setBackground(Color.BLACK);
        Run.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Run.setBounds(100, 110, 90, 25);
        Run.setForeground(Color.WHITE);
        Run.setBackground(Color.BLACK);

      JLabel Input = new JLabel("Enter The Equation");
      JTextField InputFiled = new JTextField();
      JLabel Output = new JLabel("The Output");
      JTextField OutputFiled = new JTextField();
      
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


      
        JPanel MainPanel = new JPanel();
        JPanel ButtonPanel = new JPanel();
        JPanel InputPanel = new JPanel();
        JPanel InfoPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout());
        ButtonPanel.setLayout(new FlowLayout());
        InputPanel.setLayout(new GridLayout(5,1));
        InputPanel.add(Input);
        InputPanel.add(InputFiled);
        InputPanel.add(Output);
        InputPanel.add(OutputFiled);

        ButtonPanel.add(Run);
        ButtonPanel.add(Clear);
        MainPanel.add(ButtonPanel, BorderLayout.SOUTH);
        MainPanel.add(InputPanel, BorderLayout.CENTER);
        MainPanel.add(InfoPanel, BorderLayout.NORTH);


        
        this.add(MainPanel);
        this.setVisible(true);
        this.setTitle("Compiler");
        this.setSize(700, 500);
        this.setLocation(320,130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
