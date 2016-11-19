package com.computepatterns.problemsolving.linkedlist;

/**
 * Swap nodes in singly linked list.
 * Time complexity - Worst case O(n).
 */
public class SwapNodesLinkedList {

    /**
     * Represents nodes in the linked list.
     */
    static class Node{
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

    public void swapNodes(int positionOfNode1, int positionOfNode2){
        // Note - Edge conditions such as the first and last elements not taken care of.
        Node previousOfNode1 = null;
        Node previousOfNode2 = null;

        /* 1. Find the previous node of nodes to be swapped. */
        Node currentNode = start;
        int position = 1;
        while(null != currentNode && null != currentNode.getNext()){
            // -1 used to find the previous node
            if(position == positionOfNode1 - 1){
                previousOfNode1 = currentNode;
            }else if(position == positionOfNode2 - 1){
                previousOfNode2 = currentNode;
            }

            if(null != previousOfNode1 && null != previousOfNode2){
                break;
            }
            currentNode = currentNode.getNext();
            position++;
        }

        /* 2.Do swapping */
        // Preparing temp variable - Actual nodes to be swapped.
        Node node1 = previousOfNode1.getNext();
        Node node2 = previousOfNode2.getNext();

        // Preparing temp variable - Node 1 & Node 2 links in the list.
        Node node1Next = node1.getNext();
        Node node2Next = node2.getNext();

        // Initiate swaps - Making assignments.
        previousOfNode1.setNext(node2);
        previousOfNode2.setNext(node1);

        // Closing swap - Establishing links with the rest of the link.
        node2.setNext(node1Next);
        node1.setNext(node2Next);

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

    public static void main(String[] args) {
        // Create linked list
        SwapNodesLinkedList linkedList = new SwapNodesLinkedList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);

        linkedList.setStart(node1);

        // Print list before swap.
        linkedList.printList();

        // Swap nodes with values - 3 & 6.
        linkedList.swapNodes(3,6);

        // Print after swap.
        linkedList.printList();
    }
}

