package classes;

import abstracts.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ShopImp implements Shop {
    private final List<Product> products;
    private final List<Category> categories;
    private final List<Order> orders;
    private final ConsoleInterface console;
    private Cart cart;

    public ShopImp(ConsoleInterface console) {
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.console = console;
    }

    @Override
    public void printProductList() {
        console.tell("Сейчас в магазине есть следующие товары:");
        if (products.isEmpty()) {
            console.tell("в магазине нет товаров.");
        } else {
            for (int i = 1; i <= products.size(); i++) {
                console.tell(i + " -- " + products.get(i - 1).toString()); //пример DRY, один из многих
            }
        }
    }

    @Override
    public void printProductList(String filter) {
        StringBuilder sb = new StringBuilder();
        for (Product product : products
        ) {
            try {
                if (product.getName().equals(filter)
                        || product.getCategory().toString().equals(filter)
                        || product.getPrice() <= Integer.parseInt(filter)) {
                    sb.append(product).append("\n");
                }
            } catch (NumberFormatException e) {
            }
        }

        if (sb.toString().equals("")) {
            console.tell("Таких товаров нет!");
        } else {
            console.tell(sb.toString());
        }

    }

    @Override
    public void addToCart(Product product) {
        if (cart == null) {
            cart = new CartImp(console);
        }
        cart.add(product);
    }

    @Override
    public void removeFromCart(int index) {
        cart.remove(index);
    }

    @Override
    public void printCart() {
        console.tell("В вашей корзине следующие товары:");
        if (cart == null) {
            console.tell("Корзина пуста!");
        } else {
            cart.printList();
        }


    }

    @Override
    public void printOrderList() {
        console.tell("Есть следующие заказы:");
        if (orders.isEmpty()) {
            console.tell("Заказов нет!");
        }
        for (Order order : orders
        ) {
            console.tell("______________________");
            console.tell(order.toString());
            console.tell("______________________");
        }
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void printRating() {
        console.tell("Рейтинг товаров в порядке возрастания:");
        Map<Integer, Product> ratingMap = new TreeMap<>();
        for (Product pr : products
        ) {
            ratingMap.put(pr.getRating(), pr);
        }
        for (Product pr : ratingMap.values()
        ) {
            console.tell(pr.toString());
        }
    }

    @Override
    public void newProduct(Product product) {
        products.add(product);
    }

    @Override
    public void newCategory(Category category) {
        categories.add(category);
    }

    public void printCategoryList() {
        StringBuilder sb = new StringBuilder();
        for (Category category : categories
        ) {
            sb.append(category.toString() + "\n");
        }
        if (sb.toString().equals("")) {
            console.tell("В магазине нет категорий.");
        } else {
            console.tell(sb.toString());
        }
    }

    @Override
    public List<Product> getListOfProducts() {
        return products;
    }

    @Override
    public List<Category> getListOfCategories() {
        return categories;
    }

    @Override
    public List<Order> getListOfOrders() {
        return orders;
    }


    @Override
    public void newOrder(List<Product> list) {
        Order order = new OrderImp(list);
        orders.add(order);
        console.tell("Заказ №" + order.getNumber() + " сформирован. Сумма к оплате " + order.total());
    }

    @Override
    public void repeatOrder(Order order) {
        Order order1 = order.repeat();
        orders.add(order1);
        console.tell("Заказ №" + order.getNumber() + " дублирован, создан заказ №" + order1.getNumber());
    }

}