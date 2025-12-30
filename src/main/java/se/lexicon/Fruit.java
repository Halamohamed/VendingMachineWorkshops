package se.lexicon;

/**
 * Represents a fruit product in the inventory system.
 */
public class Fruit extends Product{

    public Fruit(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    String getDescription() {
        return "Fruit: " + getName() + ", Price: " + getPrice() + " kr";
    }
}
