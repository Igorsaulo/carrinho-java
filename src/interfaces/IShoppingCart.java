package interfaces;
import java.util.List;
import models.Product;
import utilities.ChristmasDiscount;

public interface IShoppingCart {
    void addProduct(Product product);
    void removeProduct(Product product);
    List<Product> getProducts();
    double getTotal();
    void clear();
    boolean isEmapty();
    double getTotalWithDiscount();
    void setChristmasDiscount(ChristmasDiscount christmasDiscount);
}