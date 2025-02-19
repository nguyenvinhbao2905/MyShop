package homework.collection.order;

import java.util.LinkedHashSet;

public class OrderManager {
    private LinkedHashSet<Order> completedOrders = new LinkedHashSet<>();


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
