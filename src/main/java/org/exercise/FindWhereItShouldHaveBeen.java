package org.exercise;

/**
 * Created by manuel.cordoba on 3/1/16.

 Given a sorted array and a target value, return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.
 You may assume no duplicates in the array.

 [1,3,5,6], 5 -> 2
 [1,3,5,6], 2 -> 1
 [1,3,5,6], 7 -> 4
 [1,3,5,6], 0 -> 0

 */
public class FindWhereItShouldHaveBeen {

    public int whereItShouldHaveBeen(int[] sortedArray, int value) {

        int middleValueIndex = (sortedArray.length -1)/2;
        int middleValue = sortedArray[ middleValueIndex];

        if (value > sortedArray[sortedArray.length -1]) {
            return sortedArray.length;
        }

        if (middleValue == value) {
            return middleValueIndex;
        }

        if (middleValue > value) {
            return binarySearch(0, middleValueIndex, value, sortedArray);
        } else {
            return binarySearch(middleValueIndex + 1, sortedArray.length -1, value, sortedArray);
        }


    }

    private int binarySearch(int lowerIndex, int highIndex, int value, int[] sortedArray) {

        if (value > sortedArray[highIndex]) {
            return highIndex + 1;
        }

        if (value < sortedArray[lowerIndex]) {
            return lowerIndex;
        }


        int middleValueIndex = (lowerIndex + ((highIndex - lowerIndex)/2));
        int middleValue = sortedArray[ middleValueIndex];

        if (middleValue == value) {
            return middleValueIndex;
        }

        if (middleValue > value) {
            return binarySearch(lowerIndex, middleValueIndex, value, sortedArray);
        } else {
            return binarySearch(middleValueIndex + 1, highIndex, value, sortedArray);
        }
    }

}
