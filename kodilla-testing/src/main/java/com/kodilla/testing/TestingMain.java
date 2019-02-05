package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("\nTest - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();
        int a = 4;
        int b = 2;
        int additionResult = calculator.add(a, b);

        if (a+b == additionResult) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("\nTest - drugi test jednostkowy:");

        int subtractResult = calculator.subtract(a, b);

        if (a-b == subtractResult) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}
