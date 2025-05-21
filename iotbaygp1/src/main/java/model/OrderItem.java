package model;

public class OrderItem {
    private int itemID;
    private String upc, orderID;
    private int quantity;
    private Product product;

    public OrderItem(int itemID, String orderID, String upc, Product product, int quantity){
        this.itemID = itemID;
        this.orderID = orderID;
        this.upc = upc;
        this.quantity = quantity;
        this.product = product;
    }

    // Update methods
    public void addQuantity(int addition){
        if (this.product.getQuantity() >= (this.quantity + addition)){
            this.quantity += addition;
        } else {
            System.out.println("Out of Stock");
        }
    }

    public void substractQuantity(int substract){
        if (this.quantity != 0){
            this.quantity -= substract;
        } else {
            System.out.println("Error object does not exist");
        }
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    // Read methods
    public Product getProduct(){
        return this.product;
    }

    public String getOrderId(){
        return this.orderID;
    }

    public int getItemId(){
        return this.itemID;
    }

    public String getUPC(){
        return this.upc;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getTotalCost(){
        return this.quantity*this.product.getPrice();
    }

    public String toString() {
        return "Quantity: " + this.quantity + " | " + this.product.toString();
    }
}