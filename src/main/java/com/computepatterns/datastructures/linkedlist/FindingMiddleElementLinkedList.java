package com.computepatterns.datastructures.linkedlist;

/**
 * Finding middle element in singly linked list with effective time complexity.
 * Time complexity - O(n/2)
 */
public class FindingMiddleElementLinkedList {
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
     * Print the content of list.
     */
    public void printList(){
        Node currentNode = start;
        StringBuilder toPrint = new StringBuilder();
        while(null != currentNode){
            toPrint.append(currentNode.getValue() + ",");
            currentNode = currentNode.next;
        }

        System.out.println(toPrint);
    }

    public Node findMiddleNode(){
        /* Initialize slow and faster pointers. Fast pointer jumps 2 nodes in single loop */
        // Note - Idea is when the fast pointer reaches the end, the slow pointer should show the middle one.
        Node slowPtr = start;
        Node fastPtr = start;

        /* Loop through the list and and increment pointers. */
        while(true){
            // Jumps 2 nodes in a single iteration.
            if(null != fastPtr.getNext()) {
                fastPtr = fastPtr.getNext().getNext();
            }else{
                // Case - Odd length list exist condition.
                break;
            }

            // Case - Even length list exit condition.
            if(null == fastPtr){
                break;
            }

            // Standard increment.
            slowPtr = slowPtr.getNext();
        }

        return slowPtr;
    }
}
