package com.computepatterns.datastructures.linkedlist;

/**
 * Merge sort implementation in singly linked list.
 * <p>
 * Merge sort follows divide and conquer paradigm.
 * Usually a 2 step recursive process.
 * First step involves splitting the list into half at every step till the whole list is broken into individual elements.
 * Second step is merging the splitted list ensuring that at every step, partial list is sorted.
 * </p>
 * Time complexity - O(nlogn).
 */
public class MergeSortLinkedList{

    //region Singly linked list mechanics
    private Node start;

    public void setStart(Node start) {
        this.start = start;
    }

    public Node sort(Node head){

        assert (null != head);

        /* 1.Split the list*/
        /* 1.1. Split only if the head is not null and the list size is > 1 */
        if(null == head.getNext()){
            return head;
        }
        /* 1.2. Find the middle element */
        Node middleElement = findMiddleNode(head);
        /* 1.3. Get hold of head of the splitted lists. */
        Node left = head;
        Node right = middleElement;

        /* 2.Recursively split */
        Node leftSplitted = null;
        if(null != left) {
            leftSplitted = sort(left);
        }

        Node rightSplitted = null;
        if(null != right) {
            rightSplitted = sort(right);
        }

        /* 3.Merge */
        return merge(leftSplitted, rightSplitted);
    }
    //endregion

    private Node findMiddleNode(Node start){
        /* Initialize slow and faster pointers. Fast pointer jumps 2 nodes in single loop */
        // Note - Idea is when the fast pointer reaches the end, the slow pointer should show the middle one.
        Node slowPtr = start;
        Node fastPtr = start;
        Node slowPrevious = null;

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
            slowPrevious = slowPtr;
            slowPtr = slowPtr.getNext();
        }

        slowPrevious.setNext(null);
        return slowPtr.getNext();
    }

    /**
     * Merge the 2 lists while taking care of sorting.
     * @param left
     * @param right
     * @return
     */
    private Node merge(Node left, Node right){

        /* Required pointers. */
        Node mergedListStart = null;
        Node mergedListHead = null;
        boolean firstIteration = true;

        // Lists traversal heads.
        Node list1Head = left;
        Node list2Head = right;

        do{
            /* In case one of the list ends, attach the rest of the other list to the result */
            if(null == list1Head && null != list2Head){
                mergedListHead.setNext(list2Head);
                break;
            }else if(null != list1Head && null == list2Head){
                mergedListHead.setNext(list1Head);
                break;
            }else if(null == list1Head && null == list2Head) {
                break;
            }

            /* Input lists are sorted. So, compare elements from the traversal head of the lists */
            if(list1Head.getValue() <= list2Head.getValue()){
                mergedListHead.setNext(list1Head);
                mergedListHead = list1Head;
                list1Head = list1Head.getNext();
            }else{
                if(null != mergedListHead) {
                    mergedListHead.setNext(list2Head);
                    mergedListHead = list2Head;
                }else{
                    // first time scenario.
                    mergedListHead = list2Head;
                }
                list2Head = list2Head.getNext();
            }

            // first iteration.
            if(firstIteration){
                mergedListStart = mergedListHead;
                firstIteration = false;
            }
        }while(true);

        return  mergedListStart;
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
    public static class Node{
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
