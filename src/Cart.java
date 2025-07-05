import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        if (product.isPerishable() && product.isExpired()) {
            throw new IllegalStateException("Cannot add expired product: " + product.getName());
        }

        if (quantity > product.getQuantity()) {
            throw new IllegalStateException("Not enough stock for product: " + product.getName());
        }

        product.reduceQuantity(quantity);
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
