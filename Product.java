public class Product {
    String name;
    double price;
    int qty;
    public Product(String name,double price,int qty){
        this.name=name;
        this.price=price;
        this.qty=qty;
    }
    public void reduceQuantity(int quantity){
        this.qty-=quantity;
    }
    public void addQuantity(int quantity){
        this.qty+=quantity;
    }
    boolean isExpired(){
        return false;
    }
}
