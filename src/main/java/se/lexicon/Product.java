package se.lexicon;

/**
 * Represents a generic product in the inventory system.
 */
public abstract class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;

    public Product(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void reduceQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    String getDescription() {
        return "Product ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}
