package homework.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //testProduct();
//        System.out.println("------------------");
//        testUser();

//        testCart();
//        testOrder();
//        testReview();
//        testPayment();

        testDiscount();
    }
    public static void testProduct(){
        Product p = new Product("Dien thoai", 250, "Thiet bi dien tu", 30);
        p.showProduct();
    }
    public static void testUser(){
        User user = new User("bao", "bao@", "12345");
        user.displayUser();
        System.out.println("Enter your password again: ");
        String password = sc.nextLine();
        System.out.println(user.checkPassWordUseBCrypt(password));
    }
    public static void testCart() {
        Product p = new Product("Dien thoai", 260, "Thiet bi dien tu");
        Product p1 = new Product("Dien thoai ban", 200, "Thiet bi dien tu");

        Cart cart = new Cart();
        cart.add(p, 10);
        cart.add(p1, 20);
        System.out.println(cart.getTotal());
        cart.showCart();


    }

    public static void testOrder() {
        Order order = new Order();
        order.setOrderStatus(Order.OrderStatus.PROCESSING);

        System.out.println(order.getOrderStatus());
        order.updateStatus(Order.OrderStatus.PROCESSING);
        order.updateStatus(Order.OrderStatus.CANCELLED);



    }

    public static void testReview(){
        Product p = new Product("Dien thoa", 1500);
        User u = new User("bao", "bao@");

        Review rv = new Review(u, p, 5, "San pham tot");
        rv.showReview();

    }

    public static void testPayment(){
        CreditCardPayment cr = new CreditCardPayment("10537539", "bao", "20/05/2025", 150000);
        cr.processPayment(1000);

        PaypalPayment pp = new PaypalPayment("bao", 150000);
        pp.processPayment(10000);

    }

    public static void testDiscount(){
        Product p = new Product("Dien thoai", 260, "Thiet bi dien tu");
        Product p1 = new Product("Dien thoai", 2500, "Thiet bi dien tu");
        Cart cart = new Cart();
        cart.add(p, 10);
        Discount dc = new Discount();
        dc.applyDiscount(p, 10);
        System.out.println("Product price after discount: " + p.getPrice());


        HashMap<Product, Integer> hashMap = new HashMap<>();
        hashMap.put(p, 10);
        hashMap.put(p1, 20);

        Cart cart1 = new Cart(hashMap);

        dc.applyBulkDiscount(cart1, 1, 15);
        System.out.println("The total value of the product in the cart after discount: " + cart1.getTotal());

    }

}
