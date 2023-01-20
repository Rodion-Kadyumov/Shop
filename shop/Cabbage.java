package shop;

public class Cabbage extends Goods implements Food {
    private final String name = "капуста";
    private final int price = 100;

    @Override
    public int getPrice() {
        return getPrice();
    }

    @Override
    public void weigh() {
        System.out.println("Произвожу взвешивание капусты");
    }

    @Override
    public String toString() {
        return "Cabbage{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
