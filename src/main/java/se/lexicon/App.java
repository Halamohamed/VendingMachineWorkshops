package se.lexicon;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        VendingMachineImpl vendingMachine = new VendingMachineImpl();
        vendingMachine.addProduct(new Snack(1, "Chips", 15, 10));
        vendingMachine.addProduct(new Beverage(2, "Soda", 10, 20));
        vendingMachine.addProduct(new Snack(3, "Chocolate", 20, 5));
        vendingMachine.addProduct(new Beverage(4, "Water", 5, 30));
        vendingMachine.addProduct(new Beverage(5, "Juice", 12, 15));
        vendingMachine.addProduct(new Fruit(6, "Apple", 8, 25));
        vendingMachine.addProduct(new Fruit(7, "Banana", 6, 30));
        ConsoleUI consoleUI = new ConsoleUI(vendingMachine);
        consoleUI.start();

    }
}
