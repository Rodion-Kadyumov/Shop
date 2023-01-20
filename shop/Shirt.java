package shop;

public class Shirt extends Goods implements Clothes {
    private String name = "рубашка";
    private int price = 5000;

    public int getPrice() {
        return price;
    }

    public void iron() {
        System.out.println("Рубашка поглажена");
    }

    @Override
    public void tryOn() {
        System.out.println("Можете примерить рубашку");
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
