package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> listOfCountry = new ArrayList<>();

    public void addCountry(Country country){
        listOfCountry.add(country);
    }

    public ArrayList<Country> getListOfCountry(){
        return new ArrayList<>(listOfCountry);
    }
}
