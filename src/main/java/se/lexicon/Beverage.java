package se.lexicon;

/**
 * Represents a beverage product in the inventory system.
 */
public class Beverage extends Product{

    public Beverage(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    String getDescription() {
        return "Beverage: " + getName() + ", Price: " + getPrice() + " kr";
    }


}
