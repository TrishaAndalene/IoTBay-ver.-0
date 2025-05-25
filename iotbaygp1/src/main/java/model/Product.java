package model;
import java.io.Serializable;

enum StockStatus{
    UNAVAILABLE, LOW, AVAILABLE;
}
// Product Object
public class Product implements Serializable{
    
    // Attributes
    protected String upc, name, colour, brand, size, img, description;
    protected double price, ratings;
    protected int quantity, reviews;
    protected StockStatus stock;
    protected Categories categories;

    // Construtor
    public Product(String upc, String name, Double price, String brand, String colour, String size, String img, Integer quantity, Categories category, String description){
        this.upc = upc;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.colour = colour;
        this.size = size;
        this.img = img;
        this.quantity = quantity;
        this.categories = category;
        this.description = description;
    }


    // Update methods
    public void setName(String newName){
        this.name = newName;
    }

    public void setStock(){
        if (this.quantity == 0){
            this.stock = StockStatus.UNAVAILABLE;
        } else if (this.quantity > 50){
            this.stock = StockStatus.AVAILABLE;
        } else {
            this.stock = StockStatus.LOW;
        }
    }

    public void setColour(String newColour){
        this.colour = newColour;
    }

    public void setBrand(String newBrand){
        this.brand = newBrand;
    }

    public void setSize(String newSize){
        this.size = newSize;
    }

    public void setDescription(String newDesc){
        this.description = newDesc;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public void setCategories(Categories category){
        this.categories = category;
    }

    // additional may be minus
    public void updateQuantity(int additional){
        this.quantity += additional;
    }

    // ratings and reviews
    public void updateRatings(double newRatings){
        double currentRatingsPoints = this.ratings*this.reviews;
        this.ratings = (currentRatingsPoints + newRatings)/(this.reviews+1);
    }

    // Read methods
    public String getName(){
        return this.name;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getColour(){
        return this.colour;
    }
    public String getSize(){
        return this.size;
    }

    public String getImg(){
        return this.img;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getDescription(){
        return this.description;
    }

    public String getUPC(){
        return this.upc;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public Categories getCategories(){
        return this.categories;
    }

    @Override
    public String toString (){
        return this.getName();
    }
    
}