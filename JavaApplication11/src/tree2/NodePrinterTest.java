/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree2;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*; 
import javax.swing.JTree;

/**
    (c) GPLv3 2010-09-24
*/
class MNode {

    MNode l; // left
    MNode r; // right
    int t;   // value

    public MNode (int t, MNode l, MNode r) {
        this.l = l;
        this.r = r;
        this.t = t;
    }

    public void add (MNode mn) { 
        if (l == null && t > mn.t) 
            l = mn;
        else if (t > mn.t) 
            l.add (mn);
        else if (r == null) 
            r = mn;
        else    r.add (mn);     
    }
}

abstract class NodePrinter {

    abstract void nodeprint (MNode root);
    int max (int a, int b) { return (a > b) ? a : b; }
    int depth (MNode n) 
    {
        if (n.l == null && n.r == null) return 1;
        if (n.l == null) return 1 + depth (n.r);
        if (n.r == null) return 1 + depth (n.l);
        return 1 + max (depth (n.l), depth (n.r));
    }
}

class SwingPrinter extends NodePrinter {

    void nodeprint (MNode root) {   
        JFrame jf = new JFrame ("Mein Freund, der Baum, ist tot");
        jf.setSize (380, 380);
        jf.setLocationRelativeTo (null);
        JTree jt = new JTree (translate2SwingTree (root));
        jf.add (jt);
        openSubnodes (0, jt);
        jf.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE); 
        jf.setVisible (true);
    }

    /**
        Open current branch.
        We need TreePath AND row.
        Open the MNode, iterierate with the row one step, and check there, 
        whether the Branch is a part of the new branch. 
        @param row the row of the starting MNode. 
    */
    void openSubnodes (int row, JTree jt) {
        TreePath tp = jt.getPathForRow (row);
        jt.expandRow (row);
        if (tp.isDescendant (jt.getPathForRow (row + 1)))
            openSubnodes (row + 1, jt);
    }

    DefaultMutableTreeNode translate2SwingTree (MNode ast) 
    {
        DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode ("" + ast.t);
        if (ast.l != null) 
            dmtn.add (translate2SwingTree (ast.l));
        if (ast.r != null) 
            dmtn.add (translate2SwingTree (ast.r));
        return dmtn;
    }   
}

class TreeCanvas extends JPanel {

    private MNode root;
    private NodePrinter np;

    public TreeCanvas (MNode root, NodePrinter np) {
        this.root = root;
        this.np = np;
        d = np.depth (root);
        rows = (2 * d); // - 1
        cols = 2 << d;
    }

    private int d;
    private int rows;
    private int cols;

    // @override 
    public void paint (Graphics g) {
        Dimension dim = getSize ();
        int xf = dim.width / cols;
        int yf = dim.height / rows;
        int fontsize = (xf + yf) / 2;
        g.setFont (g.getFont().deriveFont (fontsize* 1.5f));
        xyPrint (root, dim.width/2, dim.width/2, 1, xf, yf, g);
    }

    /**
        ___50 60 70__________________
      10    |     x0    x0-x1:  (50,30) - (60, 10)  
      20    |    /  \   x0-x2:  (60,10) - (70, 30)
      30    |  x1    x2
    */
    void xyPrint (MNode n, int x, int dx, int y, int xf, int yf, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke (new BasicStroke (3.0f));

        g.drawString ("" + n.t, x - xf, (y+1) * yf);
        g.setColor (Color.BLACK);
        if (n.l != null) {
            g.drawLine (x - (dx/2) + xf, (y+2) * yf, x, (y+1) * yf); // line:Up
            xyPrint (n.l, x - dx/2, dx/2, y + 2, xf, yf, g);
        }
        if (n.r != null) {
            g.drawLine (x + xf, (y+1) * yf, x + (dx/2), (y+2) * yf); // line down
            xyPrint (n.r, x + dx/2, dx/2, y + 2, xf, yf, g);
        }
    }
}

class ColorSwingPrinter extends NodePrinter {

    void nodeprint (MNode root) {   
        JFrame jf = new JFrame ("Rootnode");
        jf.setSize (650, 520);
        jf.setLocationRelativeTo (null);
        jf.add (new TreeCanvas (root, this));
        jf.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
        jf.setVisible (true);
    }
}

class RootNode extends MNode {

    public RootNode (String s) 
    {
        super (Integer.parseInt ("" + s.charAt (0)), null, null);
        for (String elem: s.substring (2).split (" "))
        {
            int i = Integer.parseInt (elem);
            MNode mn = new MNode (i, null, null);
            super.add (mn);
        }
    }   
}

public class NodePrinterTest {

    public static void main (String [] args) 
    {
        String param = "6 7 4 3 8 11 2 9 7 4 5";
         /*              6
                     4      7
                3       5       8
            2                       9
        */              
        RootNode root = new RootNode (param);
        ColorSwingPrinter printer = new ColorSwingPrinter ();
        printer.nodeprint (root);
        SwingPrinter printer2 = new SwingPrinter ();
        printer2.nodeprint (root);
    }   
}
