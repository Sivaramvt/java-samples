package com.computepatterns.problemsolving.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for merging sorted linked list.
 */
public class MergeSortedLinkedListTest {

    @Test
    public void testMergeSortedLists() throws Exception {
        MergeSortedLinkedList.Node lst1_node1 = new MergeSortedLinkedList.Node(5);
        MergeSortedLinkedList.Node lst1_node2 = new MergeSortedLinkedList.Node(10);
        MergeSortedLinkedList.Node lst1_node3 = new MergeSortedLinkedList.Node(15);
        MergeSortedLinkedList.Node lst1_node4 = new MergeSortedLinkedList.Node(20);
        MergeSortedLinkedList.Node lst1_node5 = new MergeSortedLinkedList.Node(25);
        MergeSortedLinkedList.Node lst1_node6 = new MergeSortedLinkedList.Node(30);

        lst1_node1.setNext(lst1_node2);
        lst1_node2.setNext(lst1_node3);
        lst1_node3.setNext(lst1_node4);
        lst1_node4.setNext(lst1_node5);
        lst1_node5.setNext(lst1_node6);



        MergeSortedLinkedList.Node lst2_node1 = new MergeSortedLinkedList.Node(3);
        MergeSortedLinkedList.Node lst2_node2 = new MergeSortedLinkedList.Node(6);
        MergeSortedLinkedList.Node lst2_node3 = new MergeSortedLinkedList.Node(9);
        MergeSortedLinkedList.Node lst2_node4 = new MergeSortedLinkedList.Node(12);
        MergeSortedLinkedList.Node lst2_node5 = new MergeSortedLinkedList.Node(15);

        lst2_node1.setNext(lst2_node2);
        lst2_node2.setNext(lst2_node3);
        lst2_node3.setNext(lst2_node4);
        lst2_node4.setNext(lst2_node5);

        MergeSortedLinkedList algo = new MergeSortedLinkedList();

        assertEquals("3,5,6,9,10,12,15,15,20,25,30,", algo.createStringRepresentation( algo.mergeSortedLists(lst1_node1, lst2_node1)));
    }
}