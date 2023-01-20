package abstracts;

import java.util.List;

public interface Cart {
    void add(Product product);

    void remove(int index);

    void printList();

    Order flush();

    List<Product> getProducts();
}