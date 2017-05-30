package com.computepatterns.datastructures.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test reverse linked list.
 */
public class ReverseSinglyLinkedListTest {

    private ReverseSinglyLinkedListTest linkedList;

    @Test
    public void testReverse() throws Exception {


        ReverseSinglyLinkedList linkedList =  new ReverseSinglyLinkedList();

        ReverseSinglyLinkedList.Node node1 = new ReverseSinglyLinkedList.Node(1);
        ReverseSinglyLinkedList.Node node2 = new ReverseSinglyLinkedList.Node(2);
        ReverseSinglyLinkedList.Node node3 = new ReverseSinglyLinkedList.Node(3);
        ReverseSinglyLinkedList.Node node4 = new ReverseSinglyLinkedList.Node(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        linkedList.setStart(node1);

        // Before reversing.
        System.out.println(linkedList.createStringRepresentation(node1));

        // Find middle element.
        ReverseSinglyLinkedList.Node startOfReversed = linkedList.reverse();

        // After reversing.
        String stringRepresentation = linkedList.createStringRepresentation(startOfReversed);
        System.out.println(stringRepresentation);
        assertEquals("4,3,2,1,", stringRepresentation);
    }
}