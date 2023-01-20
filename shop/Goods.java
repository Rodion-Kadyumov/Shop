package shop;

public abstract class Goods {
    private String name;
    private int price;
    private int number;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public Goods setPrice(int price) {
        this.price += price;
        return this;
    }

    public Goods setNumber(int number) {
        this.number += number;
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
