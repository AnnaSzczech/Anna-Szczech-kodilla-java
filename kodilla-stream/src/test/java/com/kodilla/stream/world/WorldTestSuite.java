package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //given
        World world = new World();
        //create Country
        Country country1 = new Country("Country 1", new BigDecimal("20000000"));
        Country country2 = new Country("Country 2", new BigDecimal("10500000"));
        Country country3 = new Country("Country 3", new BigDecimal("25000000"));
        Country country4 = new Country("Country 4", new BigDecimal("22000000"));
        Country country5 = new Country("Country 5", new BigDecimal("105000000"));
        Country country6 = new Country("Country 6", new BigDecimal("95000000"));
        Country country7 = new Country("Country 7", new BigDecimal("65000000"));
        Country country8 = new Country("Country 8", new BigDecimal("12000000"));
        Country country9 = new Country("Country 9", new BigDecimal("1000000000"));
        Country country10 = new Country("Country 10", new BigDecimal("79000000"));
        Country country11 = new Country("Country 11", new BigDecimal("68600000"));
        Country country12 = new Country("Country 12", new BigDecimal("34300000"));

        //when
        // add country to continent1
        Continent continent1 = new Continent();
        continent1.addCountry(country1);
        continent1.addCountry(country2);
        continent1.addCountry(country3);
        continent1.addCountry(country4);
        // add country to continent2
        Continent continent2 = new Continent();
        continent2.addCountry(country5);
        continent2.addCountry(country6);
        continent2.addCountry(country7);
        // add country to continent3
        Continent continent3 = new Continent();
        continent3.addCountry(country8);
        continent3.addCountry(country9);
        continent3.addCountry(country10);
        continent3.addCountry(country11);
        continent3.addCountry(country12);

        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);

        //then
        // checking if the number of countries on the continent is correct
        Assert.assertEquals(4, continent1.getListOfCountry().size());
        Assert.assertEquals(3, continent2.getListOfCountry().size());
        Assert.assertEquals(5, continent3.getListOfCountry().size());

        // checking if metod getPeopleQuantity() is correct
        BigDecimal expectedPeopleQuantity = new BigDecimal("1536400000");
        Assert.assertEquals(expectedPeopleQuantity, world.getPeopleQuantity());
    }
}
