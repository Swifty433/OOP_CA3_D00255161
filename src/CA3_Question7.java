import java.util.*;

/**
 *  Name: Joseph Byrne
 *  Class Group: GD2A
 */

class Block{
    int quantity;
    double price;
    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}
public class CA3_Question7 {

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
        Map<String, Queue<Block>> stocks = new HashMap<>();
        double profit = 0;

        String command = "";
        do {
            System.out.print(">");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                String companyAc = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                if(!stocks.containsKey(companyAc))
                {
                    stocks.put(companyAc, new LinkedList<>());
                }
                stocks.get(companyAc).add(new Block(qty,price));

            } else if (command.equals("sell")) {
                String companyAc = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                if(stocks.containsKey(companyAc)){
                    Queue<Block> Stocks = stocks.get(companyAc);

                    while (qty > 0) {
                        Block block = Stocks.peek();

                        //selling all the stock at once
                        //block.quantity is ur total
                        //qty is ur amount u want to sell
                        if (block.quantity == qty) {
                            qty -= block.quantity;
                            profit = profit + block.quantity * (price - block.price);
                            Stocks.remove();
                        }
                        //if your selling it in parts
                        else {
                            profit = profit + qty * (price - block.price);
                            block.quantity -= qty;
                            qty = 0;
                        }
                    }
                }
                else{
                    System.out.println("No shares available");
                }
            }
        }while (!command.equalsIgnoreCase("quit")) ;
        System.out.println("€"+profit);
    }
}
