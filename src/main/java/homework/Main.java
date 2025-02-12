package homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //testProduct();
//        System.out.println("------------------");
//        testUser();

        testCart();

    }
    public static void testProduct(){
        Product p = new Product("Dien thoai", 250, "Thiet bi dien tu", 30);
        p.displayItems();
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
    public static Scanner sc = new Scanner(System.in);
}
