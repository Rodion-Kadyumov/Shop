package classes;

import abstracts.Category;
import abstracts.Product;

public class ProductImp extends Product implements Comparable<Product> {

    public ProductImp(String name, double price, Category category, int rating) {
        super(name, price, category, rating);
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getCategory() + ", цена: " + this.getPrice();
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.rating, o.getRating());
    }
}