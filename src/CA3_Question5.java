import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */

public class CA3_Question5
{
    private Queue<String> takeOffQueue= new LinkedList<>();
    private Queue<String> landingQueue= new LinkedList<>();
    //123


    //take off method (adds taking off to the que)
    public void takeoff(String flightSymbol)
    {
        takeOffQueue.add(flightSymbol);
        System.out.println(("Flight " + flightSymbol + " is queued for takeoff"));
    }

    // Method to add a flight to the landing queue
    public void land(String flightSymbol)
    {
        landingQueue.add(flightSymbol);
        System.out.println("Flight " + flightSymbol + " is queued for landing");
    }

    // Method to process the next flight operation (landing or takeoff)
    public void next()
    {
        if (!landingQueue.isEmpty())
        {
            String flight = landingQueue.poll();
            System.out.println("Landing " + flight);
        }
        else if (!takeOffQueue.isEmpty())
        {
            String flight = takeOffQueue.poll();
        }
        else
        {
            System.out.println("No flights in queue.");
        }
    }

    // Main method to interactively manage flight operations
    public static void main(String[] args) {
        CA3_Question5 airport = new CA3_Question5();
        Scanner scanner = new Scanner(System.in);
        String input;
        do
        {
            System.out.println("Enter command (takeoff flightSymbol, land flightSymbol, next, quit):");
            input = scanner.nextLine();
            String[] commands = input.split(" ");
            if (commands[0].equalsIgnoreCase("takeoff")) {
                airport.takeoff(commands[1]);
            } else if (commands[0].equalsIgnoreCase("land")) {
                airport.land(commands[1]);
            } else if (commands[0].equalsIgnoreCase("next")) {
                airport.next();
            }
        }
        while (!input.equalsIgnoreCase("quit"));

        scanner.close();
    }
}
