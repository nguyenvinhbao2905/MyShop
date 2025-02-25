package homework.collection.order;

import homework.collection.product.Product;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private LinkedHashSet<Order> completedOrders;
    private Map<Order, List<Product>> orderProducts;

    public OrderManager() {
        completedOrders = new LinkedHashSet<>();
        orderProducts = new LinkedHashMap<>();
    }


    public void completeOrder(Order order) {
        if (order.getOrderStatus() == Order.OrderStatus.PROCESSING) {
            order.updateStatus(Order.OrderStatus.SHIPPED);

            completedOrders.add(order);
            System.out.println("Order completed: " + order.getOrderId());
        }
    }
    public void showCompletedOrders() {
        for (Order o : completedOrders) {
            System.out.println("OrderId: " + o.getOrderId() + ", Status: " + o.getOrderStatus());
        }
    }



}
