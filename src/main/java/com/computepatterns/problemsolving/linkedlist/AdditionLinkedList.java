package com.computepatterns.problemsolving.linkedlist;

/**
 * Find the sum of 2 numbers represented in 2 linked lists.
 * <p>
 *     Inputs and output to be expressed in singly linked list.
 *     Assume that both the inputs have same number of digits.
 * </p>
 */
public class AdditionLinkedList extends AbstractSinglyLinkedList{
    /* Traversal head of the result */
    private Node resultTraversalHead;

    /**
     * Finds the sum recursively, create the node representing sum of the nodes and add it to result.
     * @param input1
     * @param input2
     * @return Carry if the sum of digits represented by nodes > 9.
     */
    private int findSumRecursively(Node input1, Node input2){

        int carry = 0;

        /* Recurse till the end of both the inputs */
        if(null != input1.getNext() && null != input2.getNext()) {
            carry = findSumRecursively(input1.getNext(), input2.getNext());
        }

        /* Find out sum while coming back from recursion. */
        int sum = input1.getValue() + input2.getValue();

        /* Deal with the carry */
        sum += carry;
        int value = sum;
        if(sum > 9){
            value = sum % 10;
        }

        /* Form result */
        Node currentNode = new Node(value);
        if(null != resultTraversalHead) {
            currentNode.setNext(resultTraversalHead);
        }
        resultTraversalHead = currentNode;

        // Return carry.
        if(sum > 9) {
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * Find the sum of numbers expressed in singly linked list. Both the inputs to have same number of digits.
     * @param input1Start
     * @param input2Start
     * @return Start node of the result.
     */
    public Node findSum(Node input1Start, Node input2Start){
        int carry = findSumRecursively(input1Start, input2Start);
        if(carry > 0){
            Node currentNode = new Node(carry);
            currentNode.setNext(resultTraversalHead);
            resultTraversalHead = currentNode;
        }
        return resultTraversalHead;
    }
}
