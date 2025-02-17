package homework.oop.user;

import homework.oop.order.Order;
import homework.oop.product.Product;

import java.util.ArrayList;

import java.util.List;


public class Admin extends User {

    private List<Product> products;

    public Admin(String name, String email, String password) {
        super(name, email, password);
        this.products = new ArrayList<>();
        permissions.add(Permission.MANAGE_PRODUCTS);
        permissions.add(Permission.MANAGE_ORDERS);
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Admin added product: " + product.getName());
    }
    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println("Admin removed product: " + product.getName());
    }
    public void approveOrder(Order order) {
        order.updateStatus(Order.OrderStatus.SHIPPED);
        System.out.println("Admin approved order and shipped: " + order.getOrderId());
    }

    @Override
    public void showPermissions() {
        System.out.println("Admin permissions: " + permissions);
    }
}
