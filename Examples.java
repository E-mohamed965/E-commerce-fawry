import java.time.LocalDate;

public class Examples {
    public static class Cheese extends ExpirableProduct implements Shipable{
    double weight;
        public Cheese(String name, double price, int quantity, LocalDate expireDate, double weight) {
            super(name, price, quantity, expireDate);
            this.weight = weight;
        }
        public String getName(){
       return this.name;
        }
        public double getWeight(){
            return this.weight;
        }
    }

    public static class TV extends Product implements Shipable {
        double weight;

        public TV(String name, double price, int quantity, double weight) {
            super(name, price, quantity);
            this.weight = weight;
        }

        @Override
        public double getWeight() {
            return weight;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
