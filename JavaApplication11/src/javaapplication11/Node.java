
package javaapplication11;

class Trunk
{
    Trunk prev;
    String str;
 
    Trunk(Trunk prev, String str)
    {
        this.prev = prev;
        this.str = str;
    }
};
 
// A Binary Tree Node
public class Node
{
    String data;
    Node left, right;
 
    Node() {}
    Node(String data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}
 
class Main
{
    public static void showTrunks(Trunk p)
    {
        if (p == null) {
            return;
        }
 
        showTrunks(p.prev);
        System.out.print(p.str);
    }
 
    public static void printTree(Node root, Trunk prev, boolean isLeft)
    {
        if (root == null) {
            return;
        }
 
        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);
 
        printTree(root.right, trunk, true);
 
        if (prev == null) {
            trunk.str = "->";
        }
        else if (isLeft) {
            trunk.str = "/—";
            prev_str = "   |";
        }
        else {
            trunk.str = "\\—";
            prev.str = prev_str;
        }
 
        showTrunks(trunk);
        System.out.println(" " + root.data);
 
        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";
 
        printTree(root.left, trunk, false);
    }
 
    public static void main(String[] args)
    {
        // Construct above tree
        Node root = new Node("=");
        root.left = new Node("ID1");
        root.right = new Node("+");
        root.right.left = new Node("-");
        root.right.right = new Node("*");
        root.right.left.left = new Node("5");
        root.right.left.right = new Node("5");
        root.right.right.left = new Node("5");
        root.right.right.right = new Node("5");
 
        // print constructed binary tree
        String x = "";
        printTree(root, null, false);
        
        System.out.println();
    }
}