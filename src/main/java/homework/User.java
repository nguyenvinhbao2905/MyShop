package homework;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Scanner;

public class User {
    private String name;
    private String mail;
    private String password;


    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User(String name, String mail, String rawPassword) {
        this.name = name;
        this.mail = mail;
//        this.password = hashPassword(rawPassword);
        this.password = hashPasswordUserBCrypt(rawPassword);
    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String hashPassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }
    public boolean checkPassword(String inputPassword) {
        return encoder.matches(inputPassword, this.password);
    }

    public String hashPasswordUserBCrypt(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
    }

    public boolean checkPassWordUseBCrypt(String inputPassword) {
        return BCrypt.checkpw(inputPassword, this.password);
    }

    public void displayUser() {
        System.out.println("Name: " + name);
        System.out.println("Mail: " + mail);
    }

    public void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
    }

    public boolean checkPasswordInList(List<String> passwords){
        return passwords.stream().anyMatch(this::checkPassword);
    }


}
