
package Controller;

import View.Output;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        Output run = new Output();
        System.out.println("############################");
        System.out.print("Please enter the equation = ");
        String y = q.next();
        System.out.println("############################");
        run.RUN(y);
        System.out.println("############################");

    }
}
