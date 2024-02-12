import java.util.Stack;
import java.util.Scanner;

/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */

public class CA3_Question2
{
    // Inner class to represent a pair of row and column indices
    private static class Pair
    {
        int row, col;

        public Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    // Method to initialize the 10x10 array with zeros
    public static int[][] floodFillStart()
    {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    // Method to display the 10x10 array
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    // Method to perform flood fill starting from the given row and column indices
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Pair> stack = new Stack<>();
        int count = 1;
        stack.push(new Pair(r, c));

        // Iterative flood fill algorithm using a stack
        while (!stack.isEmpty())
        {
            Pair current = stack.pop();
            int row = current.row;
            int col = current.col;

            // Check if the current cell is empty (filled with zero)
            if (arr[row][col] == 0)
            {
                arr[row][col] = count++; // Fill the cell with the current count
                // Check the neighboring cells (north, east, south, west) and push them onto the stack if they are within bounds
                if (row > 0) stack.push(new Pair(row - 1, col)); // north
                if (row < 9) stack.push(new Pair(row + 1, col)); // south
                if (col > 0) stack.push(new Pair(row, col - 1)); // west
                if (col < 9) stack.push(new Pair(row, col + 1)); // east
            }
        }
    }

    // Method to start the flood fill process
    public static void start()
    {
        Scanner kb = new Scanner(System.in);
        int[][] arr = floodFillStart(); // Initialize the array with zeros

        // Prompt the user to enter the starting row and column indices
        System.out.print("Enter starting row (0-9): ");
        int startRow = kb.nextInt();
        System.out.print("Enter starting column (0-9): ");
        int startCol = kb.nextInt();

        // Perform flood fill starting from the given row and column indices
        fill(startRow, startCol, arr);

        // Display the resulting array
        display(arr);
    }

    public static void main(String[] args)
    {
        start(); // Start the flood fill process
    }
}
