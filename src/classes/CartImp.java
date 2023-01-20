package classes;

import abstracts.Cart;
import abstracts.ConsoleInterface;
import abstracts.Order;
import abstracts.Product;

import java.util.ArrayList;
import java.util.List;

public class CartImp implements Cart {
    private List<Product> products;
    private final ConsoleInterface console;

    public CartImp(ConsoleInterface consoleInterface) {
        this.console = consoleInterface;
        products = new ArrayList<>();
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        products.remove(index);
    }

    @Override
    public void printList() {
        if (products.isEmpty()) {
            console.tell("В корзине нет товаров!");
        } else {
            for (Product product : products
            ) {
                console.tell(product.toString());
            }
        }

    }

    @Override
    public Order flush() {
        Order order = new OrderImp(products);
        this.products = new ArrayList<>();
        return new OrderImp(products);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}