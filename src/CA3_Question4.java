import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        // Create a File object with the given filename.
        File file = new File(filename);
        // Create a Scanner object to read from the file
        Scanner scanner = new Scanner(file);

        // Stack to keep track of opening tags.
        Stack<String> tagStack = new Stack<>();

        // Loop through each token in the file.
        while (scanner.hasNext())
        {
            // Get the next token.
            String tag = scanner.next();

            // Check if it's a closing tag.
            if(tag.startsWith("</"))
            {
                if (tagStack.isEmpty() || !tagStack.pop().equals(tag.substring(2)))
                {
                    // If the stack is empty or the closing tag doesn't match the last opening tag, return false.
                    return false;
                }
            }
            // Check if it's an opening tag
            else if (tag.startsWith("<"))
            {
                // Push the tag onto the stack.
                tagStack.push(tag.substring(1));
            }
        }

        // If the stack is empty, all opening tags have been closed.
        return tagStack.isEmpty();

    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
