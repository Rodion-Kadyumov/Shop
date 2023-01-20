package abstracts;

import java.util.List;

public abstract class Order {

    protected int number;
    protected List<Product> productList;

    public abstract Order repeat();

    public abstract double total();

    public List<Product> getProductList() {
        return productList;
    }

    public int getNumber() {
        return number;
    }
}
