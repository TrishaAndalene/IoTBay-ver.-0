package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ListItem implements Serializable{
    private ArrayList<Product> allProducts;

    // Hashmap key for brand, category
    HashMap<Categories, ArrayList<Product>> listByCategory;
    HashMap<String, ArrayList<Product>> listByBrand;
    
    public ListItem(){
        this.allProducts = new ArrayList<>();
    }
    
    public void createProduct(String upc, String name, String brand, Double price, String colour, String size, int quantity, Categories category){
        Product product = new Product(upc, name, brand, price, colour, size, quantity, category);
        this.allProducts.add(product);
        this.enterBrandHash(brand, product);
        this.enterCategoryHash(category, product);
    }

    // entering to hashmap function
    public void enterBrandHash(String brand, Product product){
        if (this.listByBrand.containsKey(brand)){
            ArrayList<Product> p = this.listByBrand.get(brand);
                p.add(product);
                this.listByBrand.put(brand, p);
        }
    }

    public void enterCategoryHash(Categories category, Product product){
        if (this.listByCategory.containsKey(category)){
            ArrayList<Product> p = this.listByCategory.get(category);
            p.add(product);
            this.listByCategory.put(category, p);
        }
    }

    public ArrayList<Product> getProducts(){
        return this.allProducts;
    }

    // Search by category
    public ArrayList<Product> searchCategory(Categories category){
        if (this.listByCategory.containsKey(category)){
            return this.listByCategory.get(category);
        } else {
            System.out.println("No item found");
            return null;
        }
    }

    // search by brand
    public ArrayList<Product> searchBrand(String brand){
        if (this.listByBrand.containsKey(brand)){
            return this.listByBrand.get(brand);
        } else {
            System.out.println("No item found");
            return null;
        }
    }

    // search by price
    public ArrayList<Product> searchPrice(double start, double end){
        ArrayList<Product> container = new ArrayList<>();
        for (Product p : this.allProducts){
            if (p.getPrice() <= end && p.getPrice() >= start){
                container.add(p);
            }
        }
        return container;
    }

    // search by colors
    public ArrayList<Product> searchColour(String colour){
        ArrayList<Product> container = new ArrayList<>();
        for (Product p : this.allProducts){
            if (p.getColour().equalsIgnoreCase(colour)){
                container.add(p);
            }
        }
        return container;
    }

    
}
