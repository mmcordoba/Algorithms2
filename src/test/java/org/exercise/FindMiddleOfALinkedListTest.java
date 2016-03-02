package org.exercise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by manuel.cordoba on 3/1/16.
 */
public class FindMiddleOfALinkedListTest {

    @Test
    public void findMiddleTest() {

        FindMiddleOfALinkedList findMiddleOfALinkedListTest = new FindMiddleOfALinkedList();

        LinkedListSimple linkedListSimple = new LinkedListSimple();
        linkedListSimple.addNode(1).addNode(2).addNode(3);

        LinkedListSimple.Node middle = findMiddleOfALinkedListTest.findMiddle(linkedListSimple);
        Assert.assertEquals(2, middle.value.intValue());


        middle = findMiddleOfALinkedListTest.findMiddle(linkedListSimple.addNode(4));
        Assert.assertEquals(3, middle.value.intValue());

        middle = findMiddleOfALinkedListTest.findMiddle(linkedListSimple.addNode(5));
        Assert.assertEquals(3, middle.value.intValue());

    }

}
