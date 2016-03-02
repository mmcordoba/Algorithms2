package org.exercise;

/**
 * Created by manuel.cordoba on 3/1/16.
 */
public class FibonacciSequenceOnN {

    public String fibbonacciSequence(int n) {
        String res = "";

        if (n >= 1) {
            res = "1";
        }

        if (n >= 2) {
            res = res + "1";
        }

        if (n > 2) {

            int n_minus_2 = 1;
            int n_minus_1 = 1;

            for (int i = 3 ; i <= n; i ++) {
                int actual = n_minus_2 + n_minus_1;
                res = res + actual;
                n_minus_2 = n_minus_1;
                n_minus_1 = actual;
            }
        }

        return res;
    }

    public int fibbonachiRecursive(int k) {
        if (k == 1 || k == 2) {
            return 1;
        } else {
            return fibonnachiInternal(1,1, k -2);
        }
    }

    private int fibonnachiInternal(int n_minus_1, int n_minus_2, int times) {
        int n =n_minus_1 + n_minus_2;

        if (1== times) {
            return n;
        } else {
            return fibonnachiInternal(n, n_minus_1, --times);
        }
    }


}
