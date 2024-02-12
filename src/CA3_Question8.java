import java.util.*;
import java.util.Scanner;
/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */
public class CA3_Question8 {
    /*
        Reads in an equation from the user
     */
    public static void main(String[] args)
    {
        boolean exit = false;
        Scanner in = new Scanner(System.in);
        while (!exit)
        {
            System.out.println("\nPlease enter an equation or type 'exit' to quit. ");
            System.out.println("Use the operators '+', '-', '*', '/', '(', ')', and numerical digits.");
            String equation = in.nextLine().trim();

            if (equation.equalsIgnoreCase("exit"))
            {
                exit = true;
                continue;
            }

            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();

            String num = "";

            for (int i = 0; i < equation.length(); i++)
            {
                char next = equation.charAt(i);

                if (Character.isDigit(next))
                {
                    num += next;
                    if (i == equation.length() - 1 || !Character.isDigit(equation.charAt(i + 1)))
                    {
                        numbers.push(Double.parseDouble(num));
                        num = "";
                    }
                }
                else if (next == '(')
                {
                    operators.push(next);

                }
                else if (next == ')')
                {
                    while (operators.peek() != '(' && numbers.size() > 1)
                    {
                        numbers.push(evaluate(numbers.pop(), numbers.pop(), operators.pop()));
                    }
                    operators.pop(); // Discard '('
                }
                else
                {
                    while (!operators.isEmpty() && operators.peek() != '(' && precedence(operators.peek()) >= precedence(next) && numbers.size() > 1)
                    {
                        numbers.push(evaluate(numbers.pop(), numbers.pop(), operators.pop()));
                    }
                    operators.push(next);
                }

                if (i == equation.length() - 1)
                {
                    while (!operators.isEmpty() && numbers.size() > 1)
                    {
                        numbers.push(evaluate(numbers.pop(), numbers.pop(), operators.pop()));
                    }
                }
            }
            System.out.printf("\nAnswer = %.2f", numbers.peek());
        }
        System.out.println("BYE BYE");
    }

    // Evaluates the result of the given operation.
    public static double evaluate(double b, double a, char op)
    {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '/' -> a / b;
            default -> a * b;
        };
    }

    //Returns the precedence of the operator.
    public static int precedence(char op)
    {
        return (op == '+' || op == '-') ? 1 : 2;
    }
}
