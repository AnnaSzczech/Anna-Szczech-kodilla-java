package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> listOfContinents = new ArrayList<>();

    public void addContinent(Continent continent){
        listOfContinents.add(continent);
    }

    public ArrayList<Continent> getListOfContinents(){
        return new ArrayList<>(listOfContinents);
    }

    public BigDecimal getPeopleQuantity(){
        return listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountry().stream())
                .map(peopleQuantity -> peopleQuantity.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));
    }
}
