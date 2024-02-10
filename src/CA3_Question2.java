import java.util.Stack;
import java.util.Scanner;

/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */

public class CA3_Question2 {
    private static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int[][] floodFillStart() {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    public static void display(int[][] arr) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    private static void fill(int r, int c, int[][] arr) {
        Stack<Pair> stack = new Stack<>();
        int count = 1;
        stack.push(new Pair(r, c));

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            int row = current.row;
            int col = current.col;

            if (arr[row][col] == 0) {
                arr[row][col] = count++;
                // Check north, east, south, west neighbors
                if (row > 0) stack.push(new Pair(row - 1, col)); // north
                if (row < 9) stack.push(new Pair(row + 1, col)); // south
                if (col > 0) stack.push(new Pair(row, col - 1)); // west
                if (col < 9) stack.push(new Pair(row, col + 1)); // east
            }
        }
    }

    public static void start() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = floodFillStart();

        System.out.print("Enter starting row (0-9): ");
        int startRow = kb.nextInt();
        System.out.print("Enter starting column (0-9): ");
        int startCol = kb.nextInt();

        fill(startRow, startCol, arr);
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }
}
