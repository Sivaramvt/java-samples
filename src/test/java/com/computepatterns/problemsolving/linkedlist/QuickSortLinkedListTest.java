package com.computepatterns.problemsolving.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for quick sort implementation on linked list.
 */
public class QuickSortLinkedListTest {

    @Test
    public void testQuickSort_case1() throws Exception {

        QuickSortLinkedList linkedList =  new QuickSortLinkedList();

        QuickSortLinkedList.Node node1 = new QuickSortLinkedList.Node(40);
        QuickSortLinkedList.Node node2 = new QuickSortLinkedList.Node(3);
        QuickSortLinkedList.Node node3 = new QuickSortLinkedList.Node(10);
        QuickSortLinkedList.Node node4 = new QuickSortLinkedList.Node(20);
        QuickSortLinkedList.Node node5 = new QuickSortLinkedList.Node(7);
        QuickSortLinkedList.Node node6 = new QuickSortLinkedList.Node(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        linkedList.setStart(node1);

        // Before reversing.
        System.out.println(linkedList.createStringRepresentation(node1));

        // Find middle element.
        QuickSortLinkedList.Node result = linkedList.quickSort(node1, node6);

        // After reversing.
        String stringRepresentation = linkedList.createStringRepresentation(result);
        System.out.println(stringRepresentation);
        assertEquals("3,4,7,10,20,40,", stringRepresentation);
    }

    @Test
    public void testQuickSort_case2() throws Exception {

        QuickSortLinkedList linkedList =  new QuickSortLinkedList();

        QuickSortLinkedList.Node node1 = new QuickSortLinkedList.Node(40);
        QuickSortLinkedList.Node node2 = new QuickSortLinkedList.Node(30);
        QuickSortLinkedList.Node node3 = new QuickSortLinkedList.Node(10);
        QuickSortLinkedList.Node node4 = new QuickSortLinkedList.Node(20);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        linkedList.setStart(node1);

        // Before reversing.
        System.out.println(linkedList.createStringRepresentation(node1));

        // Find middle element.
        QuickSortLinkedList.Node result = linkedList.quickSort(node1, node4);

        // After reversing.
        String stringRepresentation = linkedList.createStringRepresentation(result);
        System.out.println(stringRepresentation);
        assertEquals("10,20,30,40,", stringRepresentation);
    }


}