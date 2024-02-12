import java.util.*;
import java.io.*;
public class CA3_Question10
{

    public static void main(String[] args) throws FileNotFoundException
    {
        Map<String, Set<DistanceTo>> network = new HashMap<>();

            File file = new File("src/irish_places.txt");
            Scanner scanner = new Scanner(file);
            String startCity = scanner.next();

        while (scanner.hasNext())
        {
            String city1 = scanner.next();
            String city2 = scanner.next();
            int distance;

            if (scanner.hasNextInt())
            {
                distance = scanner.nextInt();
            }
            else
            {
                System.out.println("Expected an integer distance, but found: " + scanner.next());
                // Skip to the end of the line and continue to the next line
                scanner.nextLine();
                continue;
            }

            network.putIfAbsent(city1, new HashSet<>());
            network.putIfAbsent(city2, new HashSet<>());

            network.get(city1).add(new DistanceTo(city2, distance));
            network.get(city2).add(new DistanceTo(city1, distance));  // If the graph is undirected
        }
        scanner.close();

        Map<String, Integer> shortestKnownDistance = new HashMap<>();
        PriorityQueue<DistanceTo> pq = new PriorityQueue<>();

        pq.add(new DistanceTo(startCity, 0));

        while (!pq.isEmpty())
        {
            DistanceTo current = pq.poll();
            String currentCity = current.getTarget();
            int currentDistance = current.getDistance();

            if (!shortestKnownDistance.containsKey(currentCity))
            {
                shortestKnownDistance.put(currentCity, currentDistance);
                Set<DistanceTo> neighbors = network.get(currentCity);
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
