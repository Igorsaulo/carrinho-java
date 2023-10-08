package utilities;

import interfaces.IMessageManager;
import interfaces.IShoppingCart;

public class Order implements interfaces.IOrder {
    private OrderStatus orderStatus;
    private IMessageManager messageManager;
    private IShoppingCart shoppingCart;

    public enum OrderStatus {
        OPEN,
        CLOSED
    }

    public Order(IShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.messageManager = MessageManager.getInstance();
        this.orderStatus = OrderStatus.OPEN;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void checkout() {
        if (this.shoppingCart.isEmapty()) {
            this.messageManager.sendMessage("Shopping cart is empty");
            return;
        }
        this.setOrderStatus(OrderStatus.CLOSED);
        this.messageManager.sendMessage("Order closed");
    }

    public void saveOrder() {
        this.messageManager.sendMessage("Order saved");
        this.shoppingCart.clear();
    }
}