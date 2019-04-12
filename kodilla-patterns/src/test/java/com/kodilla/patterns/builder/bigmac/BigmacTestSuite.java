package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigMacNew(){
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("z sezamem")
                .burgers(2)
                .sauce("1000 wysp")
                .ingredients("ser")
                .ingredients("bekon")
                .ingredients("papryczki chilli")
                .build();
        System.out.println(bigmac);
        //when
        int howManyIngredients = bigmac.getIngredients().size();
        //then
        Assert.assertEquals(3, howManyIngredients);
    }
}
