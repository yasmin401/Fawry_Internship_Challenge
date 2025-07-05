public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean perishable;
    private boolean expired;
    private boolean requiresShipping;
    private double weight; // in kg

    public Product(String name, double price, int quantity, boolean perishable, boolean expired, boolean requiresShipping, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.perishable = perishable;
        this.expired = expired;
        this.requiresShipping = requiresShipping;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public boolean isExpired() {
        return expired;
    }

    public boolean requiresShipping() {
        return requiresShipping;
    }

    public double getWeight() {
        return weight;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}
