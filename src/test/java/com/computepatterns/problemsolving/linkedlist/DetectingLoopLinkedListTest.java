package com.computepatterns.problemsolving.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing the algorithm of detecting loop in linked list.
 */
public class DetectingLoopLinkedListTest {

    @Test
    public void testDetectLoop_loop_scenario() throws Exception {

        DetectingLoopLinkedList.Node node1 = new DetectingLoopLinkedList.Node(1);
        DetectingLoopLinkedList.Node node2 = new DetectingLoopLinkedList.Node(2);
        DetectingLoopLinkedList.Node node3 = new DetectingLoopLinkedList.Node(3);
        DetectingLoopLinkedList.Node node4 = new DetectingLoopLinkedList.Node(4);
        DetectingLoopLinkedList.Node node5 = new DetectingLoopLinkedList.Node(5);
        DetectingLoopLinkedList.Node node6 = new DetectingLoopLinkedList.Node(6);
        DetectingLoopLinkedList.Node node7 = new DetectingLoopLinkedList.Node(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node3);


        // Loop is present.
       assertEquals(true, new DetectingLoopLinkedList().detectLoop(node1));
    }

    @Test
    public void testDetectLoop_no_loop_scenario() throws Exception {

        DetectingLoopLinkedList.Node node1 = new DetectingLoopLinkedList.Node(1);
        DetectingLoopLinkedList.Node node2 = new DetectingLoopLinkedList.Node(2);
        DetectingLoopLinkedList.Node node3 = new DetectingLoopLinkedList.Node(3);
        DetectingLoopLinkedList.Node node4 = new DetectingLoopLinkedList.Node(4);
        DetectingLoopLinkedList.Node node5 = new DetectingLoopLinkedList.Node(5);
        DetectingLoopLinkedList.Node node6 = new DetectingLoopLinkedList.Node(6);
        DetectingLoopLinkedList.Node node7 = new DetectingLoopLinkedList.Node(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);


        // Loop is present.
        assertEquals(false, new DetectingLoopLinkedList().detectLoop(node1));
    }
}