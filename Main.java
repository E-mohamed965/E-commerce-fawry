import java.time.LocalDate;

public class Main {
    public static void main(String []args){
                Product cheese = new Examples.Cheese("Cheddar", 5.0, 10, LocalDate.of(2025, 7, 4), 1.2);
                Product tv = new Examples.TV("Samsung", 500, 5, 10.0);
                Product card = new Product("Mobile Scratch Card", 2.0, 20) {};

                Customer c = new Customer("John", 1000);
                //cheese.addQuantity(6);
                c.addToCart(cheese, 2);
                c.addToCart(tv, 1);
                c.addToCart(card, 3);

                c.checkout();
        }

    }

