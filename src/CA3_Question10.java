import java.util.*;
import java.io.*;
/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */
public class CA3_Question10
{

    public static void main(String[] args) throws FileNotFoundException
    {
        // Create a network map to store cities and their distances
        Map<String, Set<DistanceTo>> network = new HashMap<>();

        // Open the input file and create a scanner to read from it
        File file = new File("src/irish_places.txt");
        Scanner scanner = new Scanner(file);
        // Read the starting city from the first token in the file
        String startCity = scanner.next();

        // Process each line of the input file
        while (scanner.hasNext())
        {
            // Read city names and distance from the file
            String city1 = scanner.next();
            String city2 = scanner.next();
            int distance;

            // Check if the next token is an integer (distance)
            if (scanner.hasNextInt())
            {
                // If it is, read the distance
                distance = scanner.nextInt();
            }
            else
            {
                System.out.println("Expected an integer distance, but found: " + scanner.next());
                // Skip to the end of the line and continue to the next line
                scanner.nextLine();
                // Continue to the next line in the file
                continue;
            }

            // Add the cities and their distances to the network map
            network.putIfAbsent(city1, new HashSet<>());
            network.putIfAbsent(city2, new HashSet<>());

            network.get(city1).add(new DistanceTo(city2, distance));
            network.get(city2).add(new DistanceTo(city1, distance));  // If the graph is undirected
        }
        // Close the scanner after reading the file
        scanner.close();

        // Create maps to store shortest distances and a priority queue to process cities
        Map<String, Integer> shortestKnownDistance = new HashMap<>();
        PriorityQueue<DistanceTo> pq = new PriorityQueue<>();

        // Initialize the priority queue with the starting city and distance 0
        pq.add(new DistanceTo(startCity, 0));

        // Process cities in the priority queue until it's empty
        while (!pq.isEmpty())
        {
            // Get the next city from the priority queue
            DistanceTo current = pq.poll();
            String currentCity = current.getTarget();
            int currentDistance = current.getDistance();

            // If the city hasn't been visited yet, update its shortest distance
            if (!shortestKnownDistance.containsKey(currentCity))
            {
                shortestKnownDistance.put(currentCity, currentDistance);
                Set<DistanceTo> neighbors = network.get(currentCity);
                // If the city has neighbors, add them to the priority queue
                if (neighbors != null)
                {
                    for (DistanceTo neighbor : neighbors)
                    {
                        int newDistance = currentDistance + neighbor.getDistance();
                        pq.add(new DistanceTo(neighbor.getTarget(), newDistance));
                    }
                }
            }
        }

        // Print shortest distances
        for (Map.Entry<String, Integer> entry : shortestKnownDistance.entrySet())
        {
            System.out.println("Shortest distance from " + startCity + " to " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
