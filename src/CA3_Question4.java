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
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        Stack<String> tagStack = new Stack<>();

        while (scanner.hasNext())
        {
            String tag = scanner.next();

            if(tag.startsWith("</"))
            {
                if (tagStack.isEmpty() || !tagStack.pop().equals(tag.substring(2)))
                {
                    return false;
                }
            }
            else if (tag.startsWith("<"))
            {
                tagStack.push(tag.substring(1));
            }
        }

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
