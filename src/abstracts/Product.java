package abstracts;

public abstract class Product {

    protected String name;
    protected double price;

    protected int rating;
    protected Category category;


    public Product() {
        name = "неизвестно";
        price = 0;
        category = null;
        rating = 0;

    }

    public Product(String name, double price, Category category, int rating) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public Category getCategory() {
        return category;
    }

    public void changeRating(int change) {
        rating += change;
    }


}
