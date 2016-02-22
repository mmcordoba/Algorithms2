package org.exercise;

import org.exerrcise.MaximumDifference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumDifferenceTest {

    private MaximumDifference maximumDifference;

    @Before
    public void setUp() {
        maximumDifference = new MaximumDifference();
    }

    @Test
    public void calculateMaximumDifference() {

        Assert.assertEquals(8,maximumDifference.maximumDifference(new Integer[]{2,3,2,10,8,1}));

        Assert.assertEquals(28,maximumDifference.maximumDifference(new Integer[]{2,3,2,30,8,1,20}));

    }
}
