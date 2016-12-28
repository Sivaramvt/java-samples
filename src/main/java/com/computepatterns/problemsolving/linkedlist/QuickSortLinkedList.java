package com.computepatterns.problemsolving.linkedlist;

/**
 * Quick sort implementation for singly linked list.
 * Worst case complexity - O(n^2). Worst case is rare.
 * Preferred over merge sort as this is in-place sorting (requires no additional memory).
 */
public class QuickSortLinkedList extends AbstractSinglyLinkedList {

    public Node quickSort(Node start, Node end){
        /* Exist condition */
        // If the list contains one or less node, return the start node itself.
        if(null == start || null == start.getNext() || start == end){
            return start;
        }
        /* Partition the list */
        // Result contains start/end of left and right segments and the pivot.
        Node[] result = partition(start, end);

        /* Recur the left side */
        Node resultLeft = null; //Start of left result.
        if(null != result[0]) {

            resultLeft = quickSort(result[0], result[1]);
        }

        /* Recur the right side */
        Node resultRight = null; // Start of right result.
        if(null != result[3]){
            resultRight = quickSort(result[3], result[4]);
        }

        /* Connect the pivot to the start of right segmen */
        if(resultRight !=null) {
            result[2].setNext(resultRight);
        }

        /* Return start of the list */
        if(null == resultLeft){
            // If left segment has nothing, return pivot.
            return result[2];
        }else{
            // Else return the start of left.
            return  resultLeft;
        }
    }

    /**
     * Partitioning.
     * <p>
     *     Details - Choose the last node as pivot.
     *     Traverse and move the nodes with bigger value than pivot to the right of pivot.
     * </p>
     * @param start
     * @param end
     * @return Array of nodes[Start of left, end of left, pivot, start of right, end of right]
     */
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
}
