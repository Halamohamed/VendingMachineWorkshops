package se.lexicon;

import java.util.*;

public class VendingMachineImpl implements IVendingMachine{

    private int balance;
    private Map<Integer,Product> products;
    Set<Integer> COINS; // coin values in kr

    public VendingMachineImpl() {
        this.balance = 0;
        this.products = new HashMap<>();
        this.COINS = Set.of(1,2,5,10,20,50);
    }

    @Override
    public void insertCoin(int coin) {

        if ( COINS.contains(coin)){
            balance += coin;
        } else {
            throw new IllegalArgumentException("Invalid coin inserted: " + coin);
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
            throw new IllegalArgumentException("Product with ID " + productId + " does not exist.");
        }
        if (product.getPrice() > balance) {
            throw new IllegalArgumentException("You have not balance to purchase this product.");
        }
        balance -= product.getPrice();
        product.reduceQuantity();

        return product;
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
