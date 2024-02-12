import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**

 * Name: Joseph Byrne
 * Class Group: GD2A
 */

public class CA3_Question3
{
    // Method to read the file and create an index of identifiers
    public static void readFile(String fileName) throws FileNotFoundException
    {
        // Initialize a HashMap to store identifiers and their line numbers
        HashMap<String, StringBuilder> index = new HashMap<>();

        // Read the file
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        // Track the current line number
        int lineNumber = 0;

        // Loop through each line of the file
        while(scanner.hasNextLine())
        {

            // Increment the line number
            lineNumber++;

            // Read the current line
            String line = scanner.nextLine();

            // Create a scanner to tokenize the line
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[^A-Za-z0-9_]+");

            // Loop through each token in the line
            while(lineScanner.hasNext())
            {
                String identifier = lineScanner.next();

                // Check if the token is a Java keyword
                if(!javaWord(identifier))
                {

                    // If the token is not a Java keyword, add it to the index
                    if (!index.containsKey(identifier))
                    {
                        index.put(identifier, new StringBuilder());
                    }
                    index.get(identifier).append(lineNumber).append(", ");
                }

            }
            lineScanner.close();
        }

        // Print the index
        for(String identifier : index.keySet())
        {
            System.out.println(identifier + ": " + index.get(identifier).toString());
        }

    }

    // Method to check if a string is a Java keyword
    public static boolean javaWord(String identifier)
    {

        String[] javaKeywords =
                {
                        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
                        "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
                        "final", "finally", "float", "for", "if", "goto", "implements", "import", "instanceof",
                        "int", "interface", "long", "native", "new", "package", "private", "protected", "public",
                        "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
                        "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"
                };

        // Check if the identifier matches any Java keyword
        for(String keyword: javaKeywords)
        {
            if(identifier.equals(keyword))
            {
                return true;
            }

        }
        return false;
    }

    // Main method to start the program
    public static void main(String[] args) throws FileNotFoundException
    {
        try
        {
            // Read the file and create the index
            readFile("src/CA3_Question1.java");
        }
        catch (FileNotFoundException e)
        {
            // Throw a runtime exception if the file is not found
            throw new RuntimeException(e);
        }

    }
}
