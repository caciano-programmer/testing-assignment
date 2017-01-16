package cen4270.models;

public class Item {
    private String ID;

    private String name;

    private int price;

    private int inventoryCount;

    public Item(String ID, String name, int price, int inventoryCount) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.inventoryCount = inventoryCount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
