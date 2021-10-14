package model;

// This class represents an item/service that a business offers
public class Item {
    private String name;
    private double price;
    private String description;

    //EFFECTS: constructs an item object when called
    public Item(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //EFFECTS: return the item description
    public String getDescription() {
        return description;
    }

    //EFFECTS: return the item name
    public String getName() {
        return name;
    }

    //EFFECTS: return the item price
    public double getPrice() {
        return price;
    }

    //MODIFIES: this
    //EFFECTS: updates item description to passed in argument
    public void setDescription(String description) {
        this.description = description;
    }

    //MODIFIES: this
    //EFFECTS: updates item name to passed in argument
    public void setName(String name) {
        this.name = name;
    }

    //MODIFIES: this
    //EFFECTS: updates item price to passed in argument
    public void setPrice(double price) {
        this.price = price;
    }

}

