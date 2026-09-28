package model;

public class MenuItem {

    private int itemId;
    private String itemName;
    private double price;
    private boolean available;

    public MenuItem() {

        this(
                0,
                "Unknown",
                0.0,
                false
        );
    }

    public MenuItem(
            int itemId,
            String itemName,
            double price,
            boolean available) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.available = available;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {

        return String.format(
                "%d | %-22s | Rs. %.2f | %s",
                itemId,
                itemName,
                price,
                available
                        ? "Available"
                        : "Unavailable"
        );
    }
}