package homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            testProduct();
        System.out.println("------------------");
            testUser();

    }
    public static void testProduct(){
        Product p = new Product("Dien thoai", 25000000.0, "Thiet bi dien tu", 30);
        p.displayItems();
    }
    public static void testUser(){
        Scanner sc = new Scanner(System.in);
        User user = new User("bao", "bao@", "12345");
        user.displayUser();
        System.out.println("Enter your password again: ");
        String password = sc.nextLine();
        System.out.println(user.checkPassWordUseBCrypt(password));
    }

}
