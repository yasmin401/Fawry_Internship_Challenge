public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 5, true, false, true, 0.3);
        Product biscuits = new Product("Biscuits", 150, 10, true, false, true, 0.35);
        Product tv = new Product("TV", 2000, 2, false, false, true, 5);
        Product scratchCard = new Product("Mobile scratch card", 50, 20, false, false, false, 0);

        Customer customer = new Customer("Ahmed", 1000);

        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(scratchCard, 1);

        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);
    }
}
