package shop;

public class Apple extends Goods implements Food {
    private final String name = "яблоки";
    private final int price = 300;

    @Override
    public int getPrice() {
        return getPrice();
    }

    @Override
    public void weigh() {
        System.out.println("Произвожу взвешивание яблок");
    }

    @Override
    public String toString() {
        return "AppLe{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

