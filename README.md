# Shop
**Тема**: Magics, DRY, SOLID

**Задача**: Shop

**Пояснения**:

**Магические числа**. Пример - имплементация метода getCount() в [классе OrderImp](https://github.com/bojark/JavaPatternsHomework4/blob/fd526c0d2408f85351f56067d903840f3b6ba162/src/main/java/classes/OrderImp.java#L11). Номер заказа генерируется, и геттится через методы, а не руками.

**DRY**. Пример -- реализация интерфейса [ConsoleInterface](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/classes/ConsoleInterfaceImp.java#L1-L33), реализация [списка команд](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/classes/Commands.java) через Enum и доступ к нему по методу [commands()](https://github.com/Rodion-Kadyumov/Shop/blob/2efe24bbab04c06900f8ecadd0d301fb868f58f0/src/classes/Main.java#L80) в Main.

**Single Responsibility Principle**. Пример -- интерфейсы и асбтрактные классы [Category](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/abstracts/Category.java), [Cart](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/abstracts/Cart.java), [Order](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/abstracts/Order.java) и т.д., методы в имплементации интерфейса [Shop](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/abstracts/Shop.java). Все отвечают за свою область задач, связаны через интерфейс **Shop**.

**Open/Close**. Пример -- [интерфейсы и абстрактные](https://github.com/Rodion-Kadyumov/Shop/tree/main/src/abstracts) методы практически для всей фунциональности, protected и private поля у реализаций. Это же может служить и примером принципа **Dependency inversion principle**: интерфейс [Shop](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/abstracts/Shop.java) и его [имплементация](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/classes/ShopImp.java) за редким исключением ссылаются на интерфейсы.

**Принцип Лисков явно не выражен**: в принципе, я не стал наследовать [Cart](https://github.com/Rodion-Kadyumov/Shop/blob/main/src/abstracts/Cart.java) от List, хотя функциональность корзины близка к списку как таковому, но сама корзина -- не список, хотя и основана на нём.
