package homework.featurejava;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    }



    public static void convertString() {
        System.out.println("Input string: ");
        String currentString = scanner.nextLine();

        String result = currentString.chars().mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining())
                .toLowerCase();
    }
}
