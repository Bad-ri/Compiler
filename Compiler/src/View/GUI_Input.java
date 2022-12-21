
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GUI_Input extends JFrame {
    public void Frame(){

        GUI_Output GUI = new GUI_Output();
        JButton Run = new JButton("RUN");
        Run.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        // Run.setBounds(100, 110, 90, 25);
        Run.setForeground(Color.BLACK);
        Run.setBackground(Color.GREEN);
        Run.setFont(new Font("Verdana", Font.PLAIN, 15));

        JLabel Separator = new JLabel(" ");
        JLabel Input = new JLabel("       Enter The Equation");
        JTextField InputFiled = new JTextField(20);
        InputFiled.setOpaque(false);
        InputFiled.setCaretColor(Color.red);
        InputFiled.setFont(new Font("Verdana", Font.PLAIN, 23));

        Input.setVerticalAlignment(JLabel.CENTER);
        Input.setFont(new Font("Verdana", Font.PLAIN, 30));
        Input.setPreferredSize(new Dimension(250, 100));
        Input.setForeground(new Color(120, 90, 40));
        Input.setBackground(new Color(100, 20, 70));
        Input.setVerticalAlignment(JLabel.CENTER);

        //x=x+5*5-x

        Run.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String y = InputFiled.getText();
                GUI.RUN(y);
            }});


        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(3, 1));
        JPanel MainPanel = new JPanel();
        JPanel BorderPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout());
        BorderPanel.setLayout(new FlowLayout());
        //InputPanel.setLayout(new GridLayout(5,1));

        TitledBorder border = new TitledBorder("Compiler");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.DARK_GRAY);
        border.setTitleFont(new Font("Verdana", Font.HANGING_BASELINE, 20));
        MainPanel.setBorder(border);

        Panel.add(Input);
        Panel.add(InputFiled);
        // Panel.add(Separator);

        BorderPanel.add(Panel);
        MainPanel.add(Run, BorderLayout.SOUTH);
        MainPanel.add(BorderPanel, BorderLayout.CENTER);

        this.add(MainPanel);
        this.setVisible(true);
        this.setTitle("Compiler");
        this.setSize(500, 330);
        this.setLocation(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(null,"Example of the input \n [ EXP -> EXP = EXP OP EXP OP EXP OP EXP  ] \n [ EXP -> String , Number , Pi ] \n [ OP -> + | - | \\ | * ] \n");
    }
}
