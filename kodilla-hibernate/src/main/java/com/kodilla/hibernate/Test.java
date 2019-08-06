package com.kodilla.hibernate;

public class Test {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }


    private static boolean isPalindrome(int number) {
        if (number < 0) {
            number *= -1;
        }
        int originalNumber = number;
        int reversedNumber = 0;
        do {
            reversedNumber = (reversedNumber * 10) + (number % 10);
            number = number / 10;
        } while (number > 0);
        return originalNumber == reversedNumber;
    }

}
