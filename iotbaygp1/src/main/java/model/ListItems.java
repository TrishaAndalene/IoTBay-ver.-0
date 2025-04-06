package model;
import java.io.Serializable;
import java.util.ArrayList;

public class ListItems implements Serializable{
    private final ArrayList<Product> products;
    private ArrayList<Product> allProducts = new ArrayList<>();
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> categories = new ArrayList<>();
    private ArrayList<String> collections = new ArrayList<>();
    private ArrayList<String> colours = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();

    
    public ListItems(){
        this.products = new ArrayList<>();
    }
    
    public void createProduct(String name, String brand, Double price, String colour, String size){
        Product product = new Product(name, brand, price, colour, size);
        this.allProducts.add(product);
        this.setBrand(product);
        this.setCategories(product);
        this.setCollection(product);
        this.setColour(product);
    }

    public void addProduct(Product p){
        this.products.add(p);
    }

    // ALL PRODUCT OBJECTS
    public ArrayList<Product> getProducts(){
        return this.products;
    }

    public ArrayList<Product> getAllProducts(){
        return this.allProducts;
    }
    
     // BRANDS
    public ArrayList<String> getBrands(){
        return this.brands;
    }

   
    public void setBrand(Product p){
        if (!this.brands.contains(p.getBrand())){
            this.brands.add(p.getBrand());
        }
        }

    public ArrayList<Product> getProductsByBrand(String brand){
        ArrayList<Product> productsByBrand = new ArrayList<>();
        for (Product p : this.getAllProducts()){
            if (p.getBrand().equals(brand)){
                productsByBrand.add(p);
            }
        }
        return productsByBrand;
    }

    // PRICE
    public void setPrice(Product p){
        if (!this.prices.contains(p.getPrice())){
            this.prices.add(p.getPrice());
            }
        }

    public ArrayList<Product> getProductsByPrice(Double lower, Double upper){
        ArrayList<Product> byPrice = new ArrayList<>();
        for (Product p : this.getAllProducts()){
            if (p.getPrice() >= lower && p.getPrice() <= upper){
                byPrice.add(p);
            }
        }
        return byPrice;
    }


    // COLOUR  
    public void setColour(Product p){
        if (!this.colours.contains(p.getColour())){
            this.colours.add(p.getColour());
        }
    }

    public ArrayList<Product> getProductsByColour(String colour){
        ArrayList<Product> byColour = new ArrayList<>();
        for (Product p : this.getAllProducts()){
            if (p.getColour().equals(colour)){
                byColour.add(p);
            }
        }
        return byColour;
    }


    //  CATEGORIES

    public void setCategories(Product p){
        for (String cat : p.getCategories()){
            if (!this.categories.contains(cat)){
                this.categories.add(cat);
                }
            }
        }

    public ArrayList<String> getCategories(){
        return this.categories;
    }

    public ArrayList<Product> getProductsByCategory(String cat){
        ArrayList<Product> byCat = new ArrayList<>();
        for (Product p : this.getAllProducts()){
            if (p.getCategories().contains(cat)){
                byCat.add(p);
            }
        }
        return byCat;
    }

    // COLLECTIONS
    public void setCollection(Product p){
        if (!this.collections.contains(p.getColletion())){
            this.collections.add(p.getColletion());
            }
        }

    public ArrayList<String> getCollections(){
        return this.collections;
    }

    // RATING
    public ArrayList<Product> getByRating(int lower, int upper){
        ArrayList<Product> withinRating = new ArrayList<>();
        for (Product p : this.getAllProducts()){
            if (p.getRating() >= lower && p.getRating() <= upper){
                withinRating.add(p);
            }
        }
        return withinRating;
    }


    public ListItems demoProducts(){
        this.createProduct("Macbook", "Apple", 1990.00, "Silver", "12 inch");
        this.createProduct("28 inch monitor", "Samsung", 500.00, "Black", "28 inch");
        this.createProduct("Charging cord", "Apple", 80.00, "White", "1 metre");
        this.createProduct("iPad", "Apple", 700.00, "Black", "11 inch");
        this.createProduct("Galaxy Phone", "Samsung", 1400.00, "Silver", "128GB");
        this.createProduct("Power Bank", "Lenovo", 80.00, "White", "100 watt");
        this.createProduct("Television", "Lenovo", 1863.95, "Black", "60 inch");
        this.createProduct("Headphones", "Sony", 379.00, "Silver", "OS");
        this.createProduct("Watch", "Sony", 634.00, "White", "12 mm");

        return this;
    }
}
