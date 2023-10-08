import models.Product;
import utilities.ChristmasDiscount;
import utilities.Order;
import utilities.ShoppingCart;

public class App {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 20.0);

        ShoppingCart shoppingCart = new ShoppingCart();
        Order order = new Order(shoppingCart);

        order.checkout();

        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);

        System.out.println("Products in shopping cart:");
        for (Product product : shoppingCart.getProducts()) {
            System.out.println("Product: " + product.name + " - Price: " + product.price);
        }

        System.out.println("Total: " + shoppingCart.getTotal());

        shoppingCart.setChristmasDiscount(new ChristmasDiscount(50));

        System.out.println("Total with discount: " + shoppingCart.getTotalWithDiscount());

    }
}
