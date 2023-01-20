package classes;

import abstracts.Cart;
import abstracts.ConsoleInterface;
import abstracts.Shop;

import java.io.IOException;

public class Main {
    private static Boolean isOn = true;

    public static void main(String[] args) throws IOException {

        ConsoleInterfaceImp console = new ConsoleInterfaceImp();
        Shop shop = new ShopImp(console);
        createShop(shop);


        console.tell("Магазин открыт.");
        commands(console);

        while (isOn) {
            String com = console.ask("Введите команду.");
            switch (com) {
                case "1":
                    shop.printCategoryList();
                    break;
                case "2":
                    shop.printProductList();
                    break;
                case "3":
                    String filter = console.ask("Введите фильтр (слово или целое число " +
                            "-- максимальную цену продукта).");
                    shop.printProductList(filter);
                    break;
                case "4":
                    int index = Integer.parseInt(console.ask("Введите номер продукта (нумерация с 1)."));
                    try {
                        shop.addToCart(shop.getListOfProducts().get(index - 1));
                    } catch (IndexOutOfBoundsException e) {
                        console.tell("Такого товара не существует.");
                    }
                    break;
                case "5":
                    shop.printCart();
                    break;
                case "6":
                    Cart cart = shop.getCart();
                    if (cart == null) {
                        console.tell("Корзина пуста!");
                    } else {
                        shop.newOrder(cart.getProducts());
                    }
                    break;
                case "7":
                    shop.printOrderList();
                    break;
                case "8":
                    int i = Integer.parseInt(console.ask("Введите номер заказа для повтора."));
                    try {
                        shop.repeatOrder(shop.getListOfOrders().get(i - 1));
                    } catch (IndexOutOfBoundsException e) {
                        console.tell("Такого заказа не существует.");
                    }
                    break;
                case "9":
                    shop.printRating();
                    break;
                case "0":
                    isOn = false;
                    break;
                case "h":
                    commands(console);
            }
        }
        console.tell("Магазин завершает работу.");


    }

    //пример DRY:
    static void commands(ConsoleInterface console) {
        console.tell("Список команд:");

        for (Commands command : Commands.values()) {
            console.tell(command.toString());
        }
    }

    static void createShop(Shop shop) {
        shop.newCategory(new CategoryImp("подшипники"));
        shop.newCategory(new CategoryImp("яблоки"));
        shop.newProduct(new ProductImp("Большой подшипник", 20.1, shop.getListOfCategories().get(0), 3));
        shop.newProduct(new ProductImp("Малый подшипник", 10.05, shop.getListOfCategories().get(0), 4));
        shop.newProduct(new ProductImp("Красное яблоко", 25.5, shop.getListOfCategories().get(1), 6));
        shop.newProduct(new ProductImp("Синее яблоко", 55.5, shop.getListOfCategories().get(1), 8));
        shop.newProduct(new ProductImp("Псевдояблоко Лембита", 5.5, shop.getListOfCategories().get(1), 2));
    }


}
