package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            if (bun.equals("z sezamem") || bun.equals("bez sezamu")) {
                this.bun = bun;
            } else {
                throw new IllegalStateException("Możesz tylko wybrać \"z sezamem\" lub \"bez sezamu\"");
            }
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers > 0 && burgers < 5) {
                this.burgers = burgers;
            } else {
                throw new IllegalStateException("Możesz wybrać z zakresu 1-4");
            }
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (sauce.equals("standard") || sauce.equals("1000 wysp") || sauce.equals("barbecue")) {
                this.sauce = sauce;
            } else {
                throw new IllegalStateException("Sosy do wyboru: standard, 1000 wysp, barbecue");
            }
            return this;
        }

        public BigmacBuilder ingredients(String ingredient) {
            if (isIngredientAvailable(ingredient)){
                this.ingredients.add(ingredient);
            } else {
                throw new IllegalStateException("Dostępne składniki: sałata, cebula, bekon, ogórek, papryczki chilli, pieczarki, krewetki, ser");
            }
            return this;
        }

        private boolean isIngredientAvailable(String ingredient){
            List<String> availableIngredients = new ArrayList<>();
            availableIngredients.add("sałata");
            availableIngredients.add("cebula");
            availableIngredients.add("ogórek");
            availableIngredients.add("bekon");
            availableIngredients.add("papryczki chilli");
            availableIngredients.add("bekon");
            availableIngredients.add("pieczarki");
            availableIngredients.add("krewetki");
            availableIngredients.add("ser");
            
            return availableIngredients.stream()
                    .anyMatch(availableIngredient -> availableIngredient.equals(ingredient));
        }

        public Bigmac build(){
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
