package org.exercise;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuel.cordoba on 3/1/16.
 */
public class GetFistKElementsOf2ListsTest {


    @Test
    public void testAlg() {
        GetFistKElementsOf2Lists getFistKElementsOf2Lists = new GetFistKElementsOf2Lists();

        List<Integer> listA = new ArrayList<>();
        listA.add(2);
        listA.add(19);
        listA.add(23);
        listA.add(55);
        List<Integer> listB = new ArrayList<>();
        listB.add(3);
        listB.add(4);
        listB.add(5);

        List<Integer> res = getFistKElementsOf2Lists.getFirstKElementsOfTwoSortedLists(
                listA, listB, 6
        );

        Assert.assertEquals(6, res.size());
    }

}
