import java.util.List;

public class CheckoutService {
    private static final double SHIPPING_RATE_PER_KG = 10.0;

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty. Cannot checkout.");
        }

        double subtotal = 0;
        double totalWeight = 0;

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product.isPerishable() && product.isExpired()) {
                throw new IllegalStateException("Product expired: " + product.getName());
            }

            subtotal += product.getPrice() * item.getQuantity();

            if (product.requiresShipping()) {
                totalWeight += product.getWeight() * item.getQuantity();
            }
        }

        double shippingFees = totalWeight * SHIPPING_RATE_PER_KG;
        double total = subtotal + shippingFees;

        if (customer.getBalance() < total) {
            throw new IllegalStateException("Insufficient balance.");
        }

        customer.deduct(total);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            double itemTotal = item.getProduct().getPrice() * item.getQuantity();
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + itemTotal);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFees);
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("Customer current balance %.0f\n", customer.getBalance());

        new ShippingService().ship(cart.getItems());
    }
}
