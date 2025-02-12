package homework.oop;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Setter
public class Order {
    @Getter
    private int orderId;
    @Getter
    private User user;
    @Getter
    private HashMap<Product, Integer> products;
    @Getter
    private double totalPrice;
    private OrderStatus orderStatus;

    public enum OrderStatus {
            PROCESSING, SHIPPED, CANCELLED;
    }
    public Order() {}

    public Order(int orderId, User user, HashMap<Product, Integer> products, double totalPrice) {
        this.orderId = orderId;
        this.user = user;
        this.products = new HashMap<>();
        this.totalPrice = totalPrice;
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No cart found");
            return;
        }
        System.out.println("List of products:");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getName() + ", Quantity: " + quantity);
        }
    }
    public boolean updateStatus(OrderStatus newStatus) {
        if (this.orderStatus == OrderStatus.CANCELLED) {
            System.out.println("Can not change the state when the order was canceled!!!");
            return false;
        }
        if (newStatus == OrderStatus.SHIPPED || this.orderStatus != OrderStatus.PROCESSING) {
            System.out.println("The assigned order must be in the processing state.");
            return false;
        }
        this.orderStatus = newStatus;
        System.out.println("New order status: " + this.orderStatus);
        return true;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }
}
