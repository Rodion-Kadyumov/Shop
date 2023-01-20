package shop;

public class RainCoat extends Goods implements Clothes, Outerwear {
    private final String name = "плащ";
    private final int price = 6000;

    @Override
    public void tryOn() {
        System.out.println("Примерка элемента одежды с наименованием" + name);
    }

    @Override
    public void makeWarm() {
        System.out.println(name + " согревает");
    }

    @Override
    public int getPrice() {
        return getPrice();
    }

    @Override
    public int getNumber() {
        return getNumber();
    }

    @Override
    public String getName() {
        return getName();
    }

    @Override
    public String toString() {
        return "RainCoat{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}