package se.lexicon;

import java.util.Scanner;

/**
 * Console-based User Interface for the Vending Machine.
 */
public class ConsoleUI {
    IVendingMachine vendingMachine;
    Scanner scanner = new Scanner(System.in);

    public ConsoleUI(IVendingMachine vendingMachine) {

        this.vendingMachine = vendingMachine;
    }

    public void start() {
        // Implementation of the console UI interaction goes here
        while (true) {
            System.out.println("Welcome to the Vending Machine!");
            System.out.println("1. show product");
            System.out.println("2. Insert Coin");
            System.out.println("3. Purchase Product");
            System.out.println("4. Return Change");
            System.out.println("5. Exit");
            System.out.println("Please select an option:");
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
                    System.exit(0);
            }
        }
    }

    private void showProducts() {
        for (Product p : vendingMachine.getProducts()) {
            System.out.println("ID: " + p.getId() + " " + p.getDescription()+ " Quantity: " + (p.getQuantity() > 0 ? p.getQuantity() : "Out of Stock"));
        }
    }

    private void returnChange() {
        int change = vendingMachine.returnChange();
        System.out.println("Returned change: " + change + " kr");
    }

    private void purchaseProduct() {
        System.out.println("Please enter product ID to purchase:");
        int productId = scanner.nextInt();
        Product product = vendingMachine.purchaseProduct(productId);
        if (product != null)
        System.out.println("You have purchased: " + product.getDescription());
        else System.out.println("Purchase failed.");
    }

    private void insertCoin() {
        System.out.println("Please enter coin value(1, 2, 5, 10, 20, 50) to insert:");
        int coin = scanner.nextInt();
        vendingMachine.insertCoin(coin);
        System.out.println("Current balance: " + vendingMachine.getBalance() + " kr");

    }
}
