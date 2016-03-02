package org.exercise;

/**
 * Created by manuel.cordoba on 3/1/16.
 */
public class FindMiddleOfALinkedList {



    public LinkedListSimple.Node findMiddle(LinkedListSimple list) {


        LinkedListSimple.Node root = list.getRoot().next;
        LinkedListSimple.Node midle = list.getRoot();
        int count = 2;
        while(root != null) {
            if (count % 2  == 1) {
                midle = midle.next;
            }
            root = root.next;
            count++;
        }

        return midle;

    }


}
