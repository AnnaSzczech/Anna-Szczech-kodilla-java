package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //given
        User ania = new Millenials("Ania Szczech");
        User kasia = new YGeneration("Kasia Kowalska");
        User basia = new ZGeneration("Basia Nowak");

        //when
        String aniaPost = ania.sharePost();
        System.out.println(ania + " " + aniaPost);
        String kasiaPost = kasia.sharePost();
        System.out.println(kasia + " " + kasiaPost);
        String basiaPost = basia.sharePost();
        System.out.println(basia + " " + basiaPost +"\n\n");

        //then
        Assert.assertEquals("share post on Facebook", aniaPost);
        Assert.assertEquals("share post on Twitter", kasiaPost);
        Assert.assertEquals("share post on Snapchat", basiaPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //given
        User ania = new Millenials("Ania Szczech");

        //when
        String aniaPost = ania.sharePost();
        System.out.println(ania + " " + aniaPost);
        ania.setSocialPublisher(new TwitterPublisher());
        aniaPost = ania.sharePost();
        System.out.println(ania + " " + aniaPost);

        //then
        Assert.assertEquals("share post on Twitter", aniaPost);
    }
}
