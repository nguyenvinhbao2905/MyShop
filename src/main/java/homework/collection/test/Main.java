package homework.collection.test;

import homework.collection.product.Product;
import homework.collection.product.ProductManager;
import homework.collection.user.Customer;
import homework.collection.user.User;
import homework.collection.user.UserRegistry;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        testProduct();
//        testUser();
        testCustomer();
    }
    public static void testProduct(){
        ProductManager productManager = new ProductManager();

        productManager.addProduct(new Product("Laptop Dell XPS 15", 1599.99, "Electronics", 10));
        System.out.println("List product after add a product: ");
        productManager.showProducts();

        List<Product> products = new ArrayList<>();

        products.add(new Product("Smartphone", 799.99, "Electronics", 50));
        products.add(new Product("Laptop", 1299.99, "Electronics", 30));
        products.add(new Product("Wireless Headphones", 199.99, "Electronics", 100));
        products.add(new Product("Nike Air Max 270", 129.99, "Footwear", 25));
        products.add(new Product("Samsung Galaxy S23", 999.99, "Mobile Phones", 15));
        products.add(new Product("Sony WH-1000XM5 Headphones", 399.99, "Accessories", 30));
        products.add(new Product("Apple iPad Pro 12.9", 1199.99, "Tablets", 12));
        products.add(new Product("Laptop", 1299.99, "Electronics", 30));

        System.out.println("\nList product after add products: ");
        productManager.addProducts(products);
        productManager.showProducts();

        productManager.removeProduct("Nike Air Max 270");
        System.out.println("List product after remove a product: ");
        productManager.showProducts();

        System.out.println("Product has max price:");
        productManager.getMaxPriceProduct().showProduct();


        System.out.println("Product from category;");
        productManager.getProductsFromCategory("Electronics");


        productManager.sortProductsWithPrice();
        System.out.println("Product after sorting products: ");
        productManager.showProducts();


        productManager.printCategories();

    }

    public static void testUser() {
        UserRegistry user = new UserRegistry();
        user.addUser(new User("example@example.com"));

        user.checkEmail("example@example.com"); // In: "Email is existed"


        user.checkEmail("abc@example.com"); // In: "Email is not existed"
    }
    public static void testCustomer() {
        Customer customer = new Customer("Bao");
        List<Product> products = new ArrayList<>();

        products.add(new Product("Smartphone", 799.99, "Electronics", 50));
        products.add(new Product("Laptop", 1299.99, "Electronics", 30));
        products.add(new Product("Wireless Headphones", 199.99, "Electronics", 100));
        products.add(new Product("Nike Air Max 270", 129.99, "Footwear", 25));
        products.add(new Product("Samsung Galaxy S23", 999.99, "Mobile Phones", 15));
        products.add(new Product("Sony WH-1000XM5 Headphones", 399.99, "Accessories", 30));
        products.add(new Product("Apple iPad Pro 12.9", 1199.99, "Tablets", 12));
        products.add(new Product("Laptop", 1299.99, "Electronics", 30));


        customer.addFavoriteProduct(products.get(0));
        customer.addFavoriteProduct(products.get(1));
        customer.addFavoriteProduct(products.get(2));
        customer.addFavoriteProduct(products.get(3));


        // Kiểm tra sản phẩm có trong danh sách yêu thích hay không
        System.out.println("\nCheck if 'Smartphone' is favorite:");
        boolean isFav = customer.isFavoriteProduct(new Product("Smartphone", 800.0));
        System.out.println(isFav ? "Yes, it's in favorites." : "No, it's not in favorites.");

        // In toàn bộ sản phẩm yêu thích
        System.out.println("\nCustomer's favorite products:");
        customer.showFavoriteProducts();
    }


}
