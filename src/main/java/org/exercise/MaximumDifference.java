package org.exercise;

public class MaximumDifference {



    public int maximumDifference(Integer[] input) {
        int max = 0;
        for (int i = 0, j =1 ; j < input.length; j++) {

            if (input[j] - input[i] > max) {
                max = input[j] - input[i];
            }
            if (input[j] < input[i]) {
                i = j;
            }
        }

        return max;
    }

}
