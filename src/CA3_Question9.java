import java.util.Stack;

/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION { NORTH, SOUTH, EAST, WEST };

public class CA3_Question9 {
    public static void main(String[] args) {

        int[][] maze = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 2}
        };
        solve(0, 0, DIRECTION.NORTH, maze);
    }

    private static boolean isValid(int x, int y, int[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] != 1;
    }

    public static void solve(int x, int y, DIRECTION dir, int[][] maze) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            x = current[0];
            y = current[1];
            // Marking the current position the user is in
            if (maze[x][y] == 2) {
                return;
            }

            if (x == maze.length - 1 && y == maze.length - 1) {
                display(maze); // Display the maze after marking the visited positions
                System.out.println("YIPPPEEE!! WE MADE IT!! WE CAN FINALLY EAT AFTER 2 WEEKS!!");
                return;
            }

            boolean exitLocated = false;

            // Display the maze after each step for visualization
            display(maze);
            for (DIRECTION direction : DIRECTION.values()) {
                int Xnew = x;
                int Ynew = y;

                // Move according to direction
                switch (direction) {
                    case NORTH:
                        Xnew--; //Move north
                        break;
                    case SOUTH:
                        Xnew++; //Move south
                        break;
                    case EAST:
                        Ynew++; //Move east
                        break;
                    case WEST:
                        Ynew--; //Move west
                        break;
                }
                if (isValid(Xnew, Ynew, maze) && maze[Xnew][Ynew] != 6) {
                    System.out.println("moving: " + Xnew + ", " + Ynew);
                    stack.push(new int[]{Xnew, Ynew});
                    maze[Xnew][Ynew] = 6;
                    exitLocated = true;
                    break;
                }
            }
        }
        System.out.println("No path!");
    }

    private static void display(int[][] maze) {
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze.length; y++) {
                System.out.printf("%4d", maze[x][y]);
            }
            System.out.println();
        }
    }

}