package model;

public class StoreCartItem {
    private final int itemID;
    private final int cartID;
    private final String upc;
    private int quantity;

    public StoreCartItem(int itemID, int cartID, String upc, int quantity){
        this.itemID = itemID;
        this.cartID = cartID;
        this.upc = upc;
        this.quantity = quantity;
    }

    public int getItemID() {
        return this.itemID;
    }

    public int getCartID() {
        return this.cartID;
    }

    public String getUPC() {
        return this.upc;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
