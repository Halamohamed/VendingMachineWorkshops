package se.lexicon;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IVendingMachine vendingMachine = new VendingMachineImpl();
        ConsoleUI consoleUI = new ConsoleUI(vendingMachine);
        consoleUI.start();

    }
}
