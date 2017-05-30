package com.computepatterns.datastructures.linkedlist;

/**
 * Detect loop in singly linked list.
 */
public class DetectingLoopLinkedList {
    /**
     * Represents nodes in the linked list.
     */
    public static class Node{
        private int value;
        private Node next;

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

    public boolean detectLoop(Node start){
        /* Declare slow and fast pointers */
        // Fast pointer jumps 2 nodes at a time.
        Node slowPtr = start, fastPtr = start;

        /* Traverse till end node is found */
        while(null != slowPtr || null != fastPtr){
            slowPtr = slowPtr.getNext();

            // Fast pointer hops 2 nodes at a time.
            if(null != fastPtr.getNext()) {
                fastPtr = fastPtr.getNext().getNext();
            }else {
                // Reached end of linked list.
                break;
            }

        /* If both the pointers point to the same node any time, then there is a loop */
            if(slowPtr == fastPtr){
                // Loop found.
                return true;
            }
        }

        return false;
    }
}
