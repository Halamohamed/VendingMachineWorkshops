package se.lexicon;

import java.util.List;

/**
 * Interface representing a vending machine.
 */
public interface IVendingMachine {
    void insertCoin(int coin);
    int getBalance();
    Product purchaseProduct(int productId);
    int returnChange();
    List<Product> getProducts();
}
