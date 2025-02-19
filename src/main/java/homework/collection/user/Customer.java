package homework.collection.user;

import homework.collection.order.Cart;
import homework.collection.order.Review;
import homework.collection.product.Product;
import homework.collection.product.ProductManager;

import java.util.HashSet;
import java.util.Set;


public class Customer extends User {
    private Set<Product> favoriteProducts;

    public Customer(String name, String email, String password) {
        super(name, email, password);
        permissions.add(Permission.PURCHASE_ITEMS);
        permissions.add(Permission.WRITE_REVIEWS);
    }


    public Customer(String name) {
        super(name);
        favoriteProducts = new HashSet<Product>();
    }

    public void getProductsInProductManager() {
        System.out.println("Viewing products");
        for (Product product : ProductManager.getInstance().getProducts()) {
            System.out.println(product);
        }
    }

//    public void getProductInYourCart() {
//        if (permissions.contains(Permission.PURCHASE_ITEMS)) {
//            System.out.println("Viewing products in your cart");
//            Cart.getInstance().viewCart();
//        }
//        System.out.println("Permission denied!!");
//    }

//    public void addProductToYourCart(Product product, int quantity) {
//        if (permissions.contains(Permission.PURCHASE_ITEMS)) {
//            System.out.println("Adding product to your cart");
//            Cart.getInstance().addProduct(product, quantity);
//        }
//        System.out.println("Permission denied!!");
//    }
//    public void removeProductFromYourCart(Product product) {
//        if (permissions.contains(Permission.PURCHASE_ITEMS)) {
//            System.out.println("Removing product from your cart");
//            Cart.getInstance().removeProduct(product);
//        }
//        System.out.println("Permission denied!!");
//    }

    public void writeReview(Product product, int rating, String comment) {
        Review review = new Review(this, product, rating, comment);
        System.out.println(this.getName() + "wrote review for " + product);
    }
    @Override
    public void showPermissions() {
        System.out.println("Customer's permissions: " + permissions);
    }

    public void addFavoriteProduct(Product product) {
        if (favoriteProducts.add(product)) {
            System.out.println(product.getName() + " has been added to favorites.");
        } else {
            System.out.println(product.getName() + " is already in favorites.");
        }
    }
    public boolean isFavoriteProduct(Product product) {
        return favoriteProducts.contains(product);
    }

    public void showFavoriteProducts() {
        if (favoriteProducts.isEmpty()) {
            System.out.println("No favorite products");
            return;
        }
        System.out.println("Favorite products of " + super.getName() + ":");
        for (Product product : favoriteProducts) {
            System.out.println(" " + product);
        }
    }

}
