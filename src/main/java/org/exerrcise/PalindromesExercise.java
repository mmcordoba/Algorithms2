package org.exerrcise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class PalindromesExercise {


    public String[] palindromize(String[] words) {

        // Would love to break the whole thing in smaller functions... but no time :)

        String[] palindromes = new String[words.length];

        for (int k = 0; k < words.length; k++) {
            // All letters have to be even except one that can be odd to solve this problem ill store the letters and their ocurrence in a map that latter i will use to create the palindrome
            // I will sort the array for easy navigation
            String word = words[k];
            Map<String, Integer> container = new HashMap();
            char[] asArray = word.toCharArray();
            Arrays.sort(asArray);

            // but only one letter can be odd
            boolean containsOdd = false;
            boolean noPossible = false;

            char oddIndex = '@';
            int actualCount = 0;

            char existing = '@';
            // first i will find if is palindrome and build map with characteres and ocurrences, then i will build the palindrome with the map.
            for (int i = 0; i< asArray.length; i ++) {

                char actual = asArray[i];

                boolean changeCharacter = (existing != actual) && (i != 0);
                boolean isLast = i == (asArray.length - 1);

                if (changeCharacter) {

                    boolean isOdd = (actualCount % 2) != 0;
                    // if there is an odd and size is not odd then palindrome is not possible;
                    noPossible = oddLenghtCanNotHaveOddLetter(asArray, noPossible, isOdd);
                    // if there are more than one odd the palindrome is not possible
                    noPossible = noMoreThanOneOddLetter(containsOdd, noPossible, isOdd);

                    if (noPossible) {
                        break;
                    }

                    containsOdd = isOdd;

                    if (containsOdd) {
                        oddIndex = existing; // needed for building the palindrome
                    }

                    container.put("" + existing, actualCount);
                    actualCount = 0;

                }
                actualCount++;
                existing = actual;

                if (isLast) {

                    boolean isOdd = (actualCount % 2) != 0;

                    // if there is an odd and size is not odd then palindrome is not possible;
                    noPossible = oddLenghtCanNotHaveOddLetter(asArray, noPossible, isOdd);
                    // if there are more than one odd the palindrome is not possible
                    noPossible = noMoreThanOneOddLetter(containsOdd, noPossible, isOdd);
                    if (noPossible) {
                        break;
                    }


                    containsOdd = isOdd;

                    if (containsOdd) {
                        oddIndex = existing; // needed for building the palindrome
                    }

                    container.put("" + existing, actualCount);
                }

            }

            // Add the palindrome to the result
            if (noPossible) {
                palindromes[k] = "-1";
            } else {

                String palindrome = buildPalindrome(container, containsOdd, oddIndex);
                palindromes[k] = palindrome;

            }
        }
        return palindromes;

    }

    private String buildPalindrome(Map<String, Integer> container, boolean containsOdd, char oddIndex) {

        String palindrome = "";
        // we start with the odd then we build the palindrome around it
        if (containsOdd) {
            Integer oddLength = container.get("" + oddIndex);
            for (int l = 0; l < oddLength; l ++) {
                palindrome = palindrome + oddIndex;
            }

        }

        // The rest
        for (Map.Entry<String, Integer> entry : container.entrySet()) {
            // we skip the odd character
            if (!entry.getKey().equals("" + oddIndex)) {
                for (int r = 0; r < (entry.getValue() /2); r ++) {
                    palindrome = entry.getKey() + palindrome + entry.getKey();
                }
            }
        }
        return palindrome;
    }

    private boolean noMoreThanOneOddLetter(boolean containsOdd, boolean noPossible, boolean isOdd) {
        if (isOdd && containsOdd) {
            noPossible = true;
        }
        return noPossible;
    }

    private boolean oddLenghtCanNotHaveOddLetter(char[] asArray, boolean noPossible, boolean isOdd) {
        noPossible = noMoreThanOneOddLetter(isOdd, noPossible, ((asArray.length % 2) == 0));
        return noPossible;
    }


}
