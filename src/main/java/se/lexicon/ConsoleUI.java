package se.lexicon;

import java.util.Scanner;

/**
 * Console-based User Interface for the Vending Machine.
 */
public class ConsoleUI {
    IVendingMachine vendingMachine;
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor to initialize the ConsoleUI with a vending machine instance.
     * @param vendingMachine
     */
    public ConsoleUI(IVendingMachine vendingMachine) {

        this.vendingMachine = vendingMachine;
    }

    public void start() {
        boolean running = true;
        // Implementation of the console UI interaction goes here
        while (running) {
           menu();
            // Further implementation would handle user input and interact with vendingMachine
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    insertCoin();
                    break;
                case 3:
                    purchaseProduct();
                    break;
                case 4:
                    returnChange();
                    break;
                case 5:
                    System.out.println("Exiting... Vending Machine!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private void menu() {
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("1. show product");
        System.out.println("2. Insert Coin");
        System.out.println("3. Purchase Product");
        System.out.println("4. Return Change");
        System.out.println("5. Exit");
        System.out.println("Please select an option:");
    }

    /**
     * Displays the list of products available in the vending machine.
     */
    private void showProducts() {
        for (Product p : vendingMachine.getProducts()) {
            System.out.println("ID: " + p.getId() + " " + p.getDescription() + " Quantity: " + (p.getQuantity() > 0 ? p.getQuantity() : "Out of Stock"));
        }
    }

    /**
     * Returns the change to the user and displays the amount returned.
     */
    private void returnChange() {
        int change = vendingMachine.returnChange();
        System.out.println("Returned change: " + change + " kr");
    }

    /**
     * Handles the product purchase process.
     */
    private void purchaseProduct() {
        System.out.println("Please enter product ID to purchase:");
        int productId = scanner.nextInt();
        Product product = vendingMachine.purchaseProduct(productId);
        if (product != null)
            System.out.println("You have purchased: " + product.getDescription());
        else System.out.println("Purchase failed.");
    }

    /**
     * Handles the coin insertion process.
     */
    private void insertCoin() {
        System.out.println("Please enter coin value(1, 2, 5, 10, 20, 50) to insert:");
        int coin = scanner.nextInt();
        vendingMachine.insertCoin(coin);
        System.out.println("Current balance: " + vendingMachine.getBalance() + " kr");

    }
}
