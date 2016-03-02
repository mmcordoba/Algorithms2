package org.exercise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by manuel.cordoba on 3/1/16.
 */
public class FindWhereItShouldHaveBeenTest {


    @Test
    public void findWhereItShouldHaveBeen_3() {

        FindWhereItShouldHaveBeen findWhereItShouldHaveBeen = new FindWhereItShouldHaveBeen();

        int[] sortedArray = {1, 2, 5, 8, 9, 14};

        Assert.assertEquals(2, findWhereItShouldHaveBeen.whereItShouldHaveBeen(sortedArray, 3));

    }


    @Test
    public void findWhereItShouldHaveBeen_5() {

        FindWhereItShouldHaveBeen findWhereItShouldHaveBeen = new FindWhereItShouldHaveBeen();

        int[] sortedArray = {1, 2, 5, 8, 9, 14};

        Assert.assertEquals(2, findWhereItShouldHaveBeen.whereItShouldHaveBeen(sortedArray, 5));

    }

    @Test
    public void findWhereItShouldHaveBeen_16() {

        FindWhereItShouldHaveBeen findWhereItShouldHaveBeen = new FindWhereItShouldHaveBeen();

        int[] sortedArray = {1, 2, 5, 8, 9, 14};

        Assert.assertEquals(6, findWhereItShouldHaveBeen.whereItShouldHaveBeen(sortedArray, 16));


    }


    @Test
    public void findWhereItShouldHaveBeen_0() {

        FindWhereItShouldHaveBeen findWhereItShouldHaveBeen = new FindWhereItShouldHaveBeen();

        int[] sortedArray = {1, 2, 5, 8, 9, 14};
        Assert.assertEquals(0, findWhereItShouldHaveBeen.whereItShouldHaveBeen(sortedArray, 0));
    }

    @Test
    public void findWhereItShouldHaveBeen_12() {

        FindWhereItShouldHaveBeen findWhereItShouldHaveBeen = new FindWhereItShouldHaveBeen();

        int[] sortedArray = {1, 2, 5, 8, 9, 14};

        Assert.assertEquals(5, findWhereItShouldHaveBeen.whereItShouldHaveBeen(sortedArray, 12));

    }
}
