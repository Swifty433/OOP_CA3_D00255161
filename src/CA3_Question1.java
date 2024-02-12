import java.util.Stack;

/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */

public class CA3_Question1
{
    private Stack<Integer> driveway;
    private Stack<Integer> street;

    public CA3_Question1()
    {
        // Initialize the driveway and street stacks
        driveway = new Stack<>();
        street = new Stack<>();
    }

    // Method to add a car to the driveway
    public void addCar(int licensePlate)
    {
        if (licensePlate > 0)
        {
            driveway.push(licensePlate);
            System.out.println("Car " + licensePlate + " added to driveway.");
        }
        else
        {
            System.out.println("Invalid license plate number.");
        }
    }

    // Method to retrieve a car from the driveway
    public void retrieveCar(int licensePlate)
    {
        if (licensePlate < 0)
        {
            licensePlate = Math.abs(licensePlate);
            boolean found = false;
            // Search for the car in the driveway
            while (!driveway.isEmpty())
            {
                int car = driveway.pop();
                if (car == licensePlate)
                {
                    found = true;
                    System.out.println("Car " + licensePlate + " retrieved from driveway.");
                    break;
                }
                else
                {
                    street.push(car);
                    System.out.println("Car " + car + " moved to street.");
                }
            }
            // If the car is not found in the driveway
            if (!found)
            {
                System.out.println("Car " + licensePlate + " not found in driveway.");
            }
            // Move cars back to the driveway from the street
            while (!street.isEmpty())
            {
                driveway.push(street.pop());
            }
        }
        else
        {
            System.out.println("Invalid license plate number.");
        }
    }

    // Method to print the contents of the driveway
    public void printDriveway()
    {
        System.out.println("Driveway: " + driveway);
    }

    // Method to print the contents of the street
    public void printStreet()
    {
        System.out.println("Street: " + street);
    }

    public static void main(String[] args)
    {
        // Create a new parking lot instance
        CA3_Question1 parkingLot = new CA3_Question1();

        // Add cars to the driveway and print its contents
        parkingLot.addCar(1);
        parkingLot.printDriveway();
        parkingLot.addCar(2);
        parkingLot.printDriveway();
        parkingLot.addCar(3);
        parkingLot.printDriveway();
        parkingLot.addCar(4);
        parkingLot.printDriveway();
        parkingLot.addCar(5);
        parkingLot.printDriveway();

        // Retrieve a car from the driveway and print its contents
        parkingLot.retrieveCar(-2);
        parkingLot.printDriveway();
    }
}
