package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable{
    private final String name;
    private final String colour;
    private final String brand;
    private final String size;
    private Double price;
    private int qty = 0;
    private Double rating = 0.00;
    private int reviews = 0;

    private String description = null;
    private ArrayList<String> categories = new ArrayList<>();
    private final String collection = null;

    public Product(String name, String brand, Double price, String colour, String size){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.categories.add(brand);
        this.colour = colour;
        this.categories.add(colour);
        this.size = size;
        this.categories.add(size);
    }

    public String getName(){
        return this.name;
    }

    public String getBrand(){
        return this.brand;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void replen(int qty){
        this.qty += qty;
    }

    public Double sell(int qty){
        Double cost = 0.00;
        if (this.isStock(qty)){
            cost = qty * this.price;
            this.qty -= qty;}
        return cost;
    }

    public boolean isStock(int qty){
        return qty <= this.qty;
    }

    public int getStockQty(){
        return this.qty;
    }

    public String getColour(){
        return this.colour;
    }

    public String getSize(){
        return this.size;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Double getRating(){
        return this.rating / this.reviews;
    }

    public void submitRating(int stars){
        this.reviews += 1;
        this.rating += stars;
    }

    public String getColletion(){
        return this.collection;
    }

    public void addCategories(String cat){
        this.categories.add(cat);
    }

    public ArrayList<String> getCategories(){
        return this.categories;
    }
    
    public String details(){
        return this.brand + " " + this.name + " (" + this.colour + "): $" + this.price;
    }

    @Override
    public String toString(){
        return "Product: " + this.brand + " " + this.name + " (" + this.colour + "): $" + this.price;
    }
}
