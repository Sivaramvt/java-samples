package com.computepatterns.problemsolving.linkedlist;

/**
 * Quick sort implementation for singly linked list.
 */
public class QuickSortLinkedList extends AbstractSinglyLinkedList {

    public Node quickSort(Node start, Node end){
        /* Exist condition */
        // If the list contains one or less node, return the start node itself.
        if(null == start || null == start.getNext() || start == end){
            return start;
        }
        /* Partition the list */
        Node[] result = partition(start, end);


        /* Recur the left side */
        Node resultLeft = null;
        if(null != result[0]) {

            resultLeft = quickSort(result[0], result[1]);
        }

        /* Recur the right side */
        Node resultRight = null;
        if(null != result[3]){
           resultRight = quickSort(result[3], result[4]);
        }


        if(resultLeft != null)
        resultLeft.setNext(result[2]);
        if(resultRight !=null)
        result[2].setNext(resultRight);


        if(resultLeft == null){
            return result[2];
        }else{
            return  resultLeft;
        }


    }

    /*private Node partition(Node start, Node end) {
        /* Deal with list of size 1 or 2
        if(null == start || start == end || start.getNext() == end){
            return start;
        }

        int pivotValue = end.getValue();
        Node pivot = start;
        Node current = start;
        while(null != current){
            if(current.getValue() <= pivotValue){
                swap(current, pivot);
                pivot = pivot.getNext();
            }
            current = current.getNext();
        }
        return pivot;
    }*/

    private Node[] partition (Node start, Node end){
        /* Choose a pivot */
        // We are not moving pivot but the other nodes.
        Node pivot = end;

        /* Define the required pointers */
        // Tail points to the end of new list
        Node tail = end;
        // Start of newly arranged list
        Node newStart = null;
        // Iteration pointers
        Node current = start;
        Node previous = null;

        /* Iterate and move nodes */
        // Iterate the original list till the end.
        boolean isFirstNodeWithoutMove = true;
        while(null != current && end != current){
            Node next = current.getNext();
            // For nodes with value grater than pivot move to the right of pivot.
            if(current.getValue() > pivot.getValue()){
                // Move the current node to the end of the list.
                moveNodeToEnd(current, previous, tail);
                // Advance tail.
                tail = tail.getNext();
            }else{
                if(isFirstNodeWithoutMove){
                    newStart = current;
                    isFirstNodeWithoutMove = false;
                }
                // Advance iteration pointers.
                if(null != previous){
                    previous.setNext(current);
                }
                previous = current;
            }

            current = next;
        }

        /* Prepare result for returning */
        Node[] result = new Node[5];
        result[0] = newStart;
        result[1] = previous;
        result[2] = pivot;
        result[3] = pivot.getNext();
        result[4] = tail;

        return result;

    }

    private void moveNodeToEnd(Node current, Node previous, Node tail) {
        if(null != previous){
            previous.setNext(current.getNext());
        }
        current.setNext(null);
        tail.setNext(current);
    }

    private void swap(Node current, Node pivot) {
        int temp = current.getValue();
        current.setValue(pivot.getValue());
        pivot.setValue(temp);
    }

    private Node findPreviousBeforeEnd(Node start, Node end){
        Node current = start;
        Node previous = start;
        while(null != current && current != end){
            previous = current;
            current = current.getNext();
        }
        return previous;
    }

}
