package model;

public class CartItem {
    private final int itemID;
    private final int cartID;
    private final String upc;
    private int quantity;
    private Product product;

    public CartItem(int itemID, int cartID, Product product, int quantity){
        this.itemID = itemID;
        this.cartID = cartID;
        this.upc = product.getUPC();
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

    public int getCartId(){
        return this.cartID;
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

    // for testing only to reset the quantity
    public void setQuantity(int newQty){
        this.quantity = newQty;
    }

    public double getTotalCost(){
        return this.quantity*this.product.getPrice();
    }

    @Override
    public String toString() {
        return "Quantity: " + this.quantity + " | " + this.product.toString();
    }


}
