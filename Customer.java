import java.util.ArrayList;
import java.util.List;

public class Customer {
    public class CartItem{
        Product product;
        int qty;

        public CartItem(Product product, int qty) {
            this.product = product;
            this.qty = qty;
        }

        public double getItemPrice() {
            return product.price * qty;
        }
    }
    String name;
    double balance;
    List<CartItem> cart = new ArrayList<>();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= product.qty) {

            cart.add(new CartItem(product, quantity));
        } else {
            System.out.println("Cannot add more than available quantity.");
        }
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        double cartPrice = 0;
        double shippingFees = 0;
        List<Shipable> toShip = new ArrayList<>();

        for (CartItem item : cart) {
            if (item.product.isExpired()) {
                System.out.println("Cannot buy expired product: " + item.product.name);
                return;
            }
            if (item.qty > item.product.qty) {
                System.out.println("Product out of stock: " + item.product.name);
                return;
            }

            cartPrice += item.getItemPrice();

            if (item.product instanceof Shipable) {
                toShip.add((Shipable) item.product);
                shippingFees += ((Shipable) item.product).getWeight() * 1.5; // Shipping fee = weight * rate
            }
        }

        double total = cartPrice + shippingFees;

        if (balance < total) {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= total;

        for (CartItem item : cart) {
            item.product.reduceQuantity(item.qty);
        }

        System.out.printf("cartPrice: $%f\n", cartPrice);
        System.out.printf("Shipping: $%f\n", shippingFees);
        System.out.printf("Total Paid: $%f\n", total);
        System.out.printf("Remaining Balance: $%f\n", balance);

        if (!toShip.isEmpty()) {
            ShippingService.processShipping(toShip);
        }


        cart.clear();
    }
}
