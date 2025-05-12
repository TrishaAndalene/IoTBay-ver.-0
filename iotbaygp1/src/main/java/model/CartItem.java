package model;

public class CartItem {
    private int itemID;
    private int cartID;
    private String upc;
    private int quantity;

    public CartItem(int itemID, int cartID, String upc, int quantity){
        this.itemID = itemID;
        this.cartID = cartID;
        this.upc = upc;
        this.quantity = quantity;
    }

    public int getItemID() {
        return itemID;
    }

    public int getCartID() {
        return cartID;
    }

    public String getUPC() {
        return upc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }







}
