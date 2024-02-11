import java.util.Scanner;
import java.util.*;
/**
 *  Name: Joseph Byrne
 *  Class Group:
 */
public class CA3_Question8 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        System.out.println("Valid inputs include: 'Numerical digits', '+', '-', '*', '/', '(', ')'");
        String equation = in.nextLine().trim();

        Stack<Double> numbers = new Stack<>();
        Stack<Character> signs = new Stack<>();

        String num = "";

        for(int i = 0; i < equation.length(); i++)
        {
            char next = equation.charAt(i);


        }
    }

    public static double Operators(char op, double a, double b)
    {
        if(op == '+')
        {
            return a + b;
        }
        else if(op == '-')
        {
            return a - b;
        }
        else if (op == '*')
        {
            return a * b;
        }
        else
        {
            return a / b;
        }
    }




}
