package com.computepatterns.problemsolving.linkedlist;

/**
 * Merged 2 sorted singly linked lists into one. The resultant list is sorted.
 * Time complexity - O(n), n being the length of the shortest list.
 */
public class MergeSortedLinkedList {
    //region Utility code for singly linked list.
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
    //endregion

    /**
     *
     * @param list1 Sorted list 1
     * @param list2 Sorted list 2
     * @return Start of the merged list which is sorted.
     */
    public Node mergeSortedLists(Node list1, Node list2){

        /* Required pointers. */
        Node mergedListStart = null;
        Node mergedListHead = null;
        boolean firstIteration = true;

        // Lists traversal heads.
        Node list1Head = list1;
        Node list2Head = list2;

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
}
