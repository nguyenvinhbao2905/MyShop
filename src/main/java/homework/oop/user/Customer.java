package homework.oop.user;

import homework.oop.order.Cart;
import homework.oop.product.Product;
import homework.oop.order.Review;

public class Customer extends User{
    private Cart cart;



    public Customer(String name, String email, String password) {
        super(name, email, password);
        this.cart = new Cart();
        permissions.add(Permission.PURCHASE_ITEMS);
        permissions.add(Permission.WRITE_REVIEWS);
    }

    public void addToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
        System.out.println("Product added to the cart" + product.getName());
    }

    public void writeReview(Product product, int rating, String comment) {
        Review review = new Review(this, product, rating, comment);
        System.out.println(this.getName() + "wrote review for " + product);
    }
    @Override
    public void showPermissions() {
        System.out.println("Customer's permissions: " + permissions);
    }


}
