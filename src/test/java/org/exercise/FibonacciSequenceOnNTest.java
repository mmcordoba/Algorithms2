package org.exercise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by manuel.cordoba on 3/1/16.
 */
public class FibonacciSequenceOnNTest {

    @Test
    public void testFibonacciSequences() {
        FibonacciSequenceOnN fibonacciSequenceOnN = new FibonacciSequenceOnN();

        Assert.assertEquals("11235813",fibonacciSequenceOnN.fibbonacciSequence(7));
    }

    @Test
    public void testFibbonachiRecursive() {
        FibonacciSequenceOnN fibonacciSequenceOnN = new FibonacciSequenceOnN();
        Assert.assertEquals(13, fibonacciSequenceOnN.fibbonachiRecursive(7));
    }
}
