"# internet-shop" 

**_14,1_**

-Создайте свой собственный репозиторий
-Создание моделей: Product, User, ShoppingCart, Order.
-Создайте DAO и сервисный уровень для модели Товар.
-Добавьте операции CRUD в ProductDao.
-Используйте класс Storage как постоянный слой.
-Не забудьте использовать собственную аннотацию Dao.
-Используйте некоторую статическую переменную, которая будет постепенно генерировать вам идентификатор для каждой модели.
-Возврат  Optional, если вы хотите вернуть ноль в DAO. Например public Optional<User> get(Long id).
-Добавьте класс Application с методом main, где вы вызываете все свои методы из сервиса.

**ProductDao**
- Product create(Product product);
- Optional<Product> get(Long id);
- List<Product> getAll();
- Product update(Product product);
- boolean delete(Long id);

**ProductService**
- Product create(Product product);
- Product get(Long id);
- List<Product> getAll();
- Product update(Product product);
- boolean delete(Long id);

**Как мои модели должны быть связаны друг с другом?**
1. User не имеет никакого отношения к ShoppingCart, Order или Product.
2. Product не будет иметь отношения к ShoppingCart, Order или User.
3. ShoppingCart будет иметь отношения с List<Product> products и User user.
 class ShoppingCart {
    private User user;
    private List<Product> products;
 }
4. Order будет иметь отношение к List<Product> products и User user.
 class Order {
    private User user;
    private List<Product> products;
 }
