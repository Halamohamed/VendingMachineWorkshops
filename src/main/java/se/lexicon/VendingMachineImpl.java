package se.lexicon;

import java.util.*;

/**
 * VendingMachineImpl class implements the IVendingMachine interface.
 * It provides functionalities to insert coins, purchase products,
 * return change, and get the list of available products.
 */
public class VendingMachineImpl implements IVendingMachine {

    // Current balance in the vending machine
    private int balance;
    //  Available products in the vending machine
    private Map<Integer, Product> products;
    // Accepted coin denominations
    private Coin COINS; // coin values in kr

    /**
     * Constructor to initialize the vending machine with an empty product list and zero balance.
     */
    public VendingMachineImpl() {
        this.balance = 0;
        this.products = new HashMap<>();
        //this.COINS = Set.of(1, 2, 5, 10, 20, 50);
    }

    @Override
    public void insertCoin(int coin) {

        for (Coin c : Coin.values()) {
            if (c.getValue() == coin) {
                COINS = c;
                break;
            }
        }
        if (COINS.getValue() == coin) {
            balance += coin;
        } else {
            System.out.println("Invalid coin inserted: " + coin);
        }
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public Product purchaseProduct(int productId) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product with ID " + productId + " does not exist.");

        } else if (product.getPrice() > balance) {
            System.out.println("You have not balance to purchase this product.");
        } else if (product.getQuantity() <= 0) {
            System.out.println("Product is out of stock.");
        } else {
            balance -= product.getPrice();
            product.reduceQuantity();
            return product;
        }
        return null;
    }

    @Override
    public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }
}
