package homework.oop;

import org.hibernate.mapping.List;

public class Customer extends User{
    private Cart cart;
    private Review review;



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
        review = new Review(this, product, rating, comment);
        System.out.println(this.getName() + "wrote review for " + product);
    }
    @Override
    public void showPermissions() {
        System.out.println("Customer's permissions: " + permissions);
    }


}
