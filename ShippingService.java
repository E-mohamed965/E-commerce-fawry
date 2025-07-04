import java.util.List;

public class ShippingService {
    public static void processShipping(List<Shipable> items) {
        System.out.println("Shipping the following items:");
        for (Shipable item : items) {
            System.out.println("- " + item.getName() + " Weight: " + item.getWeight());
        }
    }
}
