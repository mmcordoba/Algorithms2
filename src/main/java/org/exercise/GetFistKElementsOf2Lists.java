package org.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuel.cordoba on 3/1/16.
 */
public class GetFistKElementsOf2Lists {


    public List<Integer> getFirstKElementsOfTwoSortedLists(List<Integer> listA, List<Integer> listB, int k) {

        List<Integer> res = new ArrayList<>(k);

        if (listA.size() + listB.size() >= k) {

            for (int i = 0, j = 0, count = 0; count < k; count ++) {

                if ((i < listA.size()) && (j < listB.size())) {

                    if (listA.get(i) < listB.get(j)) {
                        res.add(listA.get(i));
                        i++;
                    } else {
                        res.add(listB.get(j));
                        j++;
                    }

                } else if ((i >= listA.size())) {
                    // just add the missing elements from B
                    res.addAll(listB.subList(j, j + (k - count)));
                    break;
                } else {
                    // just add the missing elements from A
                    res.addAll(listA.subList(i, i + (k - count)));
                    break;
                }

            }

        }

        return res;

    }

}
