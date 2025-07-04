import java.time.LocalDate;

public class ExpirableProduct extends Product{
    LocalDate expireDate;

    public ExpirableProduct(String name, double price, int qty, LocalDate expiryDate) {
        super(name, price, qty);
        this.expireDate = expiryDate;
    }

    @Override
    boolean isExpired() {
        return LocalDate.now().isAfter(expireDate);
    }
}
