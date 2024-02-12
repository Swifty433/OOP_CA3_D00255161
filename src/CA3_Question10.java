import java.util.*;
import java.io.*;

/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */
public class CA3_Question10
{
    public static void main(String[] args) {
        Map<String, Set<DistanceTo>> network = new HashMap<>();

        try {
            File file = new File("irish_places.txt");
            Scanner scanner = new Scanner(file);
            String startCity = scanner.next();

            while (scanner.hasNext()) {
                String city1 = scanner.next();
                String city2 = scanner.next();
                int distance = scanner.nextInt();

                network.putIfAbsent(city1, new HashSet<>());
                network.putIfAbsent(city2, new HashSet<>());

                network.get(city1).add(new DistanceTo(city2, distance));
                network.get(city2).add(new DistanceTo(city1, distance));
            }

            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        
    }
}
