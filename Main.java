import java.time.LocalDate;

public class Main {
    public static void main(String []args){
                Product cheese = new Examples.Cheese("Cheddar", 5.0, 10, LocalDate.of(2025, 7, 4), 1.2);
                Product tv = new Examples.TV("Samsung", 500, 5, 10.0);
                Product card = new Product("Mobile Scratch Card", 2.0, 20) {};

                Customer c = new Customer("kilaney", 1000);
                Customer c2=new Customer("kilaney2", 100);
                Customer c3=new Customer("kilaney3", 1000);
                Customer c4=new Customer("kilaney4", 1000);


                c.addToCart(cheese, 2);
                c.addToCart(tv, 1);
                c.addToCart(card, 3);

                c2.addToCart(cheese, 2);
                c2.addToCart(tv, 1);
                c2.addToCart(card, 3);

                 c3.addToCart(cheese, 9);
                c3.addToCart(tv, 1);        
                c3.addToCart(card, 3); 


                //accepted checkout
                 c.checkout();
                //rejected checkout due to insufficient funds
                c2.checkout();       
                //rejected checkout due to out of stock
                c3.checkout();
                //rejectd checkout due to empty cart
                c4.checkout();

                //cannot add more than stock quantity
                c.addToCart(cheese, 20);
        }

    }

