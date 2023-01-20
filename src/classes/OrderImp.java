package classes;

import abstracts.Order;
import abstracts.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderImp extends Order {

    static int orderCount = 0;

    public OrderImp() {
        orderCount++;
        this.number = orderCount;
        this.productList = new ArrayList<>();
    }

    public OrderImp(List<Product> products) {
        orderCount++;
        this.number = orderCount;
        this.productList = products;
    }

    @Override
    public Order repeat() {
        return new OrderImp(this.getProductList());
    }

    @Override
    public double total() {
        double total = 0;
        for (Product product : productList
        ) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Заказ №" + number);
        for (Product product : productList) {
            str.append("\n").append(product);
        }
        str.append("\nСумма к оплате: ").append(total());
        return str.toString();
    }
}