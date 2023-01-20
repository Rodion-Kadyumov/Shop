package abstracts;

import java.util.List;

public interface Shop {
    void printProductList();

    void printProductList(String filter);

    void addToCart(Product product);

    void removeFromCart(int index);

    void printCart();

    Cart getCart();

    void printRating();

    void newProduct(Product product);

    void newCategory(Category category);

    void newOrder(List<Product> list);

    void repeatOrder(Order order);

    void printCategoryList();

    List<Product> getListOfProducts();

    List<Category> getListOfCategories();

    List<Order> getListOfOrders();

    void printOrderList();
}