package org.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manuel.cordoba on 3/1/16.


 Given an array of integers, find two numbers such that they add up to a specific target number.

 Example Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2

 */
public class ReachSumTarget {


    public String findIndexOfValuesThatSum(int k, int[] numbers) {

        String res = "";

        // number,index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i ++) {

            int missing  = k - numbers[i];
            Integer indexOfMissing = map.get(missing);
            if (indexOfMissing != null) {
                return indexOfMissing + "  " + i;
            }
            map.put(numbers[i], i);
        }

        return res;

    }

}
