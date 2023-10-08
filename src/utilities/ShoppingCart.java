package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Product;
import interfaces.IChristmasDiscount;
import interfaces.IMessageManager;
import interfaces.IShoppingCart;

public class ShoppingCart implements IShoppingCart {
    private List<Product> products;
    private boolean isEmapty;
    private IMessageManager messageManager;
    private IChristmasDiscount christmasDiscount;

    public ShoppingCart() {
        this.products = new ArrayList<Product>();
        this.isEmapty = true;
        this.messageManager = MessageManager.getInstance();
        this.christmasDiscount = new ChristmasDiscount(0);
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.isEmapty = false;
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
        if (this.products.size() == 0) {
            this.isEmapty = true;
        }
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(new ArrayList<Product>(this.products));
    }

    public double getTotal() {
        double total = 0.0;
        for (Product product : this.products) {
            total += product.price;
        }
        return total;
    }

    public void clear() {
        this.products.clear();
        this.isEmapty = true;
        this.messageManager.sendMessage("Shopping cart cleared");
    }

    public boolean isEmapty() {
        return this.isEmapty;
    }

    public double getTotalWithDiscount() {
        return this.christmasDiscount.applyDiscount(this.getTotal());
    }

    public void setChristmasDiscount(ChristmasDiscount christmasDiscount) {
        this.christmasDiscount = christmasDiscount;
    }
}