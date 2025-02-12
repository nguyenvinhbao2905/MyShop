package homework;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cart {
    @Getter
    @Setter
    private List<Product> products;
    private HashMap<Product, Integer> productQuantity;

//    public Cart() {
//        this.products = new ArrayList<>();
//    }
    public Cart(){
        this.productQuantity = new HashMap<>();
    }


    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.products.add(product);
        }
    }

    public void removeProduct(Product product) {
        this.products.removeIf(product1 -> product1.equals(product));
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void add(Product product, int quantity) {
        this.productQuantity.put(product, this.productQuantity.getOrDefault(product, 0) + quantity);
    }

    public void remove(Product product) {
        this.productQuantity.remove(product);
    }

    public double getTotal() {
        return productQuantity.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }


//    public void showCart() {
//        if (products.isEmpty()) {
//            System.out.println("No has items.");
//        }
//        System.out.println("List of products:");
//        for (Product product : products) {
//            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice());
//        }
//    }

    public void showCart() {
        if (productQuantity.isEmpty()) {
            System.out.println("No cart found");
            return;
        }
        System.out.println("List of products:");
        for (Map.Entry<Product, Integer> entry : productQuantity.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getName() + ", Quantity: " + quantity);
        }
    }
}