import java.util.Stack;

/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */

public class CA3_Question1 {
    private Stack<Integer> driveway;
    private Stack<Integer> street;

    public CA3_Question1() {
        driveway = new Stack<>();
        street = new Stack<>();
    }

    public void addCar(int licensePlate) {
        if (licensePlate > 0) {
            driveway.push(licensePlate);
            System.out.println("Car " + licensePlate + " added to driveway.");
        } else {
            System.out.println("Invalid license plate number.");
        }
    }

    public void retrieveCar(int licensePlate) {
        if (licensePlate < 0) {
            licensePlate = Math.abs(licensePlate);
            boolean found = false;
            while (!driveway.isEmpty()) {
                int car = driveway.pop();
                if (car == licensePlate) {
                    found = true;
                    System.out.println("Car " + licensePlate + " retrieved from driveway.");
                    break;
                } else {
                    street.push(car);
                    System.out.println("Car " + car + " moved to street.");
                }
            }
            if (!found) {
                System.out.println("Car " + licensePlate + " not found in driveway.");
            }
            while (!street.isEmpty()) {
                driveway.push(street.pop());
            }
        } else {
            System.out.println("Invalid license plate number.");
        }
    }

    public void printDriveway() {
        System.out.println("Driveway: " + driveway);
    }

    public void printStreet() {
        System.out.println("Street: " + street);
    }

    public static void main(String[] args) {
        CA3_Question1 parkingLot = new CA3_Question1();
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
        parkingLot.retrieveCar(-2);
        parkingLot.printDriveway();



    }
}
