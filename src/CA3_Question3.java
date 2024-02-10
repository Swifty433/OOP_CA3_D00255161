import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**

 Name: Joseph Byrne
 Class Group: GD2A
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        HashMap<String, StringBuilder> index = new HashMap<>();

        int lineNumber = 0;
        while(scanner.hasNextLine()){

            lineNumber++;
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[^A-Za-z0-9_]+");

            while(lineScanner.hasNext()){
                String identifier = lineScanner.next();
                if(!javaWord(identifier)){
                    if (!index.containsKey(identifier)){
                        index.put(identifier, new StringBuilder());
                    }
                    index.get(identifier).append(lineNumber).append(", ");
                }

            }
            lineScanner.close();
        }

        for(String identifier : index.keySet()){
            System.out.println(identifier + ": " + index.get(identifier).toString());
        }

    }


    public static boolean javaWord(String identifier){

        String[] javaKeywords =
                {
                        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
                        "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
                        "final", "finally", "float", "for", "if", "goto", "implements", "import", "instanceof",
                        "int", "interface", "long", "native", "new", "package", "private", "protected", "public",
                        "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
                        "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"
                };

        for(String keyword: javaKeywords)
        {
            if(identifier.equals(keyword))
            {
                return true;
            }

        }
        return false;
    }


    public static void main(String[] args) throws FileNotFoundException{
        try {
            readFile("src/CA3_Question1.java");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}