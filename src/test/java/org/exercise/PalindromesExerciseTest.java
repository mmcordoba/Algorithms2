package org.exercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromesExerciseTest {


    private PalindromesExercise palindromesExercise;

    @Before
    public void setUp() {
        palindromesExercise = new PalindromesExercise();
    }

    @Test
    public void theseArePalindromes() {

        String[] res = palindromesExercise.palindromize(new String[]{"aab", "aacccbb", "abababab", "c"});
        Assert.assertEquals("aba", res[0]);
        Assert.assertEquals("bacccab", res[1]);
        Assert.assertEquals("bbaaaabb", res[2]);
        Assert.assertEquals("c", res[3]);
    }

    @Test
    public void theseAreNotPalindromes() {

        String[] res = palindromesExercise.palindromize(new String[]{"aaabbb", "ac"});
        Assert.assertEquals("-1", res[0]);
        Assert.assertEquals("-1", res[1]);
    }
}
