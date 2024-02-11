import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */

class Block1{
    int quantity;
    double price;
    public Block1(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}
public class CA3_Question6 {

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Block> stocks = new LinkedList<>();
        double profit = 0;

        String command = "";
        do {
            System.out.print(">");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                int qty = in.nextInt();
                double price = in.nextDouble();
                stocks.add(new Block(qty, price));//adds stocks to Queue
            } else if (command.equals("sell")) {
                int qty = in.nextInt();
                double price = in.nextDouble();

                while (qty > 0) {
                    Block block = stocks.peek();

                    //selling all the stock at once
                    //block.quantity is total
                    //qty is amount u want to sell
                    if (block.quantity == qty) {
                        qty -= block.quantity;
                        profit = profit + block.quantity * (price - block.price);
                        stocks.remove();
                    }
                    //if your selling it in parts
                    else {
                        profit = profit + qty * (price - block.price);
                        block.quantity -= qty;
                        qty = 0;
                    }
                }
            }
        }
        while (!command.equalsIgnoreCase("quit")) ;
        System.out.println("€"+profit);
    }
}
