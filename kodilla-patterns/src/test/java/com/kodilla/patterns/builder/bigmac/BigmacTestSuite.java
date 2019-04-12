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
        Assert.assertEquals("z sezamem",  bigmac.getBun());
        Assert.assertEquals("1000 wysp",  bigmac.getSauce());
        Assert.assertEquals(2,  bigmac.getBurgers());
    }

    @Test
    public void testBigMacNewWithoutSauce(){
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("bez sezamu")
                .burgers(1)
                .ingredients("ser")
                .build();
        System.out.println(bigmac);
        //when
        int howManyIngredients = bigmac.getIngredients().size();
        //then
        Assert.assertEquals(1, howManyIngredients);
        Assert.assertEquals("bez sezamu",  bigmac.getBun());
        Assert.assertEquals(1,  bigmac.getBurgers());
        Assert.assertNull(bigmac.getSauce());
    }
}
