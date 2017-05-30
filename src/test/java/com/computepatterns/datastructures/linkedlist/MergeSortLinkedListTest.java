package com.computepatterns.datastructures.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for merge sort - Singly linked list.
 */
public class MergeSortLinkedListTest {

    @Test
    public void testSort() throws Exception {
        MergeSortLinkedList.Node node1 = new MergeSortLinkedList.Node(100);
        MergeSortLinkedList.Node node2 = new MergeSortLinkedList.Node(200);
        MergeSortLinkedList.Node node3 = new MergeSortLinkedList.Node(3);
        MergeSortLinkedList.Node node4 = new MergeSortLinkedList.Node(6);
        MergeSortLinkedList.Node node5 = new MergeSortLinkedList.Node(110);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        // Find middle element.
        MergeSortLinkedList linkedList = new MergeSortLinkedList();
        MergeSortLinkedList.Node sortedList = linkedList.sort(node1);
        linkedList.createStringRepresentation(sortedList);
        assertEquals(3, sortedList.getValue());
    }
}