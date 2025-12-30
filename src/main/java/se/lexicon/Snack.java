package se.lexicon;

public final class Snack extends Product{




    public Snack(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    String getDescription() {
        return "Snack: " + getName() + ", Price: " + getPrice() + " kr";
    }
}
