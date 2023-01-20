package classes;

public enum Commands {

    CATEGORYLIST("1", "Список категорий."),
    PRODUCTLIST("2", "Список продуктов."),
    PRODUCTLISTFILTER("3", "Список продуктов по фильтру."),
    ADDPRODUCT("4", "Добавить продукт в корзину."),
    CART("5", "Что в корзине?"),
    ORDER("6", "Оформить заказ."),
    ORDERS("7", "Список заказов."),
    CLONEORDER("8", "Повторить заказ."),
    RATING("9", "Рейтинг товаров."),
    END("0", "Выход."),
    HELP("h", "Список команд.");
    private final String text;
    private final String desc;

    Commands(String text, String desc) {
        this.text = text;
        this.desc = desc;
    }

    public String getText() {
        return text;
    }

    public String getDesc() {
        return desc;
    }


    @Override
    public String toString() {
        return text + " -- " + desc;
    }

}