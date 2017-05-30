package com.computepatterns.datastructures.linkedlist;

/**
 * Reverse the singly linked list.
 * Time complexity - Linear - O(n). Just one loop and reassign pointers for every node to the previous node.
 */
public class ReverseSinglyLinkedList {
    /**
     * Represents nodes in the linked list.
     */
    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        Node getNext() {
            return next;
        }


        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node start;

    public void setStart(Node start) {
        this.start = start;
    }

    /**
     * Creates string representing the sequence of the content of the list delimite by coma.
     */
    public String createStringRepresentation(Node start){
        Node currentNode = start;
        StringBuilder toPrint = new StringBuilder();
        while(null != currentNode){
            toPrint.append(currentNode.getValue() + ",");
            currentNode = currentNode.next;
        }
        return toPrint.toString();
    }


    /**
     *
     * @return Head of the revised linked
     */
    public Node reverse(){

        Node previous = null;
        Node next = null;
        Node current = start;

        while(null != current){
            next = current.getNext();
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
