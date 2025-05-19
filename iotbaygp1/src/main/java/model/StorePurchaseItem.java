package model;

public class StorePurchaseItem {
    private final int itemID;
    private final int purchaseID;
    private final String upc;
    private final int quantity;

    public StorePurchaseItem(int itemID, int purchaseID, String upc, int quantity){
        this.itemID = itemID;
        this.purchaseID = purchaseID;
        this.upc = upc;
        this.quantity = quantity;
    }

    public int getItemID() {
        return this.itemID;
    }

    public int getPurchaseID() {
        return this.purchaseID;
    }

    public String getUPC() {
        return this.upc;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
