package com.computepatterns.datastructures.linkedlist;

/**
 * Abstract implementation of singly linked list
 */
public class AbstractSinglyLinkedList {
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
     * Represents nodes in the linked list.
     */
    protected static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value &&
                    com.google.common.base.Objects.equal(next, node.next);
        }

        @Override
        public int hashCode() {
            return com.google.common.base.Objects.hashCode(value, next);
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
}
