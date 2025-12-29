package se.lexicon;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Unit tests for VendingMachineImpl class.
 */

public class VendingMachineImplTest {

    private VendingMachineImpl vendingMachine;
    private Product product;
    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachineImpl();
        product = new Beverage(1, "Coca-Cola", 15, 10);
        vendingMachine.addProduct(product);
    }
    @Test
    public void testInsertCoin() {
        vendingMachine.insertCoin(10);
        assertEquals(10, vendingMachine.getBalance());
    }

    @Test
    public void testGetBalance() {
        vendingMachine.insertCoin(10);
        vendingMachine.insertCoin(5);
        assertEquals(15, vendingMachine.getBalance());
    }

    @Test
    public void testPurchaseProduct() {
        vendingMachine.insertCoin(20);
        Product purchasedProduct = vendingMachine.purchaseProduct(1);
        assertEquals(product, purchasedProduct);
        assertEquals(9, product.getQuantity());
        assertEquals(5, vendingMachine.getBalance());
    }

    @Test
    public void testReturnChange() {
        vendingMachine.insertCoin(50);
        vendingMachine.purchaseProduct(1);
        int change = vendingMachine.returnChange();
        assertEquals(35, change);

    }

    @Test
    public void testGetProducts() {
        assertEquals(1, vendingMachine.getProducts().size());
        assertEquals(product, vendingMachine.getProducts().get(0));
    }

    @Test
    public void testAddProduct() {
        Product newProduct = new Snack(2, "Chips", 10, 5);
        vendingMachine.addProduct(newProduct);
        assertEquals(2, vendingMachine.getProducts().size());
        assertTrue(vendingMachine.getProducts().contains(newProduct));
    }
}