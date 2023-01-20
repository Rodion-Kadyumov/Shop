//Interface segregation - из интерфейса clothes был выделен отдельный интерфейс OuterWear,
//который имеет специфическое свойство - утеплять
//Open-closed principle - наследование от абстрактного класса Goods наделила дочерние классы
//общими характерными чертами, при этом мы можем так же для каждого дочернего класса создать
// уникальные черты. Таким образом, мы закрываем от модификации базовые черты товара и позволяем
//классам расшириться (приобрести уникальные только для этого конкретного товара черты).
//Dependency inversion principle - разделив интерфейсы clothes и outwear мы не зависим от общего
//функционала одного интерфейса, а можем каждый может выполнить самостоятельную функцию.
//Liskov Substitution Principle - для реализации данного принципа было создано 2 отдельных интерфейса -
// еда и одежда, посольку несмотря на то, что 2 эти категории попадают под категорю товары,каждый
// из них имеет ряд специфических характеристик присущих только им. Так яблоко будет импементировать
// интерфейс Food, а не Clothes.
//Single - responsibility - все что касается проектирования магазина находится в отдельном пакете,
// также выделены в отдельные классы все, что касается  еды и одежды.
// DRY - повторяющийся метод вывода списка товаров выносим в отдельный метод

import shop.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Goods[] goods = {new RainCoat(), new Apple(), new Cabbage(), new Shirt()};

        printGoods(goods);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер товара и количество через пробел или введите `end` ");
            String input = scanner.nextLine();
            if (input.equals("end")) break;
            String[] parts = input.split(" ");
            int goodsNumber = Integer.parseInt(parts[0]) - 1;
            goods[goodsNumber].setNumber(Integer.parseInt(parts[1]));
        }
        printGoods(goods);
        printBasket(goods);
    }

    private static void printGoods(Goods[] goods) {
        System.out.println("Ознакомьтесь со списком товаров: ");
        for (int i = 0; i < goods.length; i++) {
            System.out.println((i + 1) + ". " + goods[i]);
        }
    }

    private static void printBasket(Goods[] goods) {
        int costGoods = 0;
        System.out.println("Ваша корзина: ");
        for (Goods goodsList : goods) {
            if (goodsList.getNumber() != 0) {
                costGoods += goodsList.getNumber() * goodsList.getPrice();
                System.out.println(goods + " 'количество'= " + goodsList.getNumber() + " шт."
                        + " 'цена'= " + goodsList.getPrice() + " " +
                        " 'стоимость'= " + goodsList.getNumber() * goodsList.getPrice() + " рублей");
            }
        }
        System.out.println("Итого: " + costGoods + " " + "рублей");
    }

}