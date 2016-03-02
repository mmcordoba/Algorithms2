package org.exercise;

/**
 * Created by manuel.cordoba on 3/1/16.
 */
public class LinkedListSimple {

    private Node root;


    public Node getRoot() {
        return root;
    }

    public LinkedListSimple addNode(Integer value) {

        Node node = new Node(value);

        node.next = root;
        root = node;
        return this;
    }

    public static class Node {
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }

    }


}
