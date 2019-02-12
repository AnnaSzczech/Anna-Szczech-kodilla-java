package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args){
        System.out.println("Welcome to module 7 - Stream\n");

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("WALENTYNKI", (textToDecor) -> "1.    <3 " + textToDecor + " <3");
        poemBeautifier.beautify("anna szczech", (textToDecor) -> "2.    " + textToDecor.toUpperCase());
        poemBeautifier.beautify("ugly", (textToDecor) -> "3.    " + textToDecor.replace("ugly", "beautify").toUpperCase());
        poemBeautifier.beautify("laptop", (textToDecor) -> "4.    " + "Słowo " + textToDecor + " ma " + textToDecor.length() + " liter.");
        poemBeautifier.beautify("Basia", (textToDecor) -> "5.    " + textToDecor.replaceFirst("B", "K"));
    }
}
