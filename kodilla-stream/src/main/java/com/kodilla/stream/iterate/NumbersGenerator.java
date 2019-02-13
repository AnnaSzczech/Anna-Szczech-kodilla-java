package com.kodilla.stream.iterate;

import java.util.stream.Stream;

public class NumbersGenerator {
    public static void generateEven (int max) {
        Stream.iterate(1, i -> i++)
                .limit(max)
                .filter(i -> i % 2 ==0)
                .forEach(System.out :: println);
    }

}
