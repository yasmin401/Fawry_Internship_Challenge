import java.util.List;

public class ShippingService {
    public void ship(List<CartItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product.requiresShipping()) {
                double itemWeight = product.getWeight() * item.getQuantity();
                totalWeight += itemWeight;
                System.out.println(item.getQuantity() + "x " + product.getName() + " " + (int)(itemWeight * 1000) + "g");
            }
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
