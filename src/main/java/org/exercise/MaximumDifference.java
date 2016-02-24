package org.exercise;

public class MaximumDifference {



    public int maximumDifference(Integer[] input) {
        int max = 0;
        for (int i = 0 ; i < input.length; i++) {

            for (int k = i + 1; k < input.length; k++) {
                if (input[k] - input[i] > max) {
                    max = input[k] - input[i];
                }
                if (input[k] < input[i]) {
                    i = k;
                }
            }
        }

        return max;
    }

}
