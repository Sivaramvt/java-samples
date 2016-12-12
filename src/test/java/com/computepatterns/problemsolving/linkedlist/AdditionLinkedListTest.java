package com.computepatterns.problemsolving.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing addition of numbers expressed in singly linked list.
 */
public class AdditionLinkedListTest {

    @Test
    public void testFindSum_noCarry_sameNoOfDigits() throws Exception {
        AdditionLinkedList.Node input1Node1 = new AdditionLinkedList.Node(5);
        AdditionLinkedList.Node input1Node2 = new AdditionLinkedList.Node(6);
        AdditionLinkedList.Node input1Node3 = new AdditionLinkedList.Node(7);

        input1Node1.setNext(input1Node2);
        input1Node2.setNext(input1Node3);

        AdditionLinkedList.Node input2Node1 = new AdditionLinkedList.Node(3);
        AdditionLinkedList.Node input2Node2 = new AdditionLinkedList.Node(2);
        AdditionLinkedList.Node input2Node3 = new AdditionLinkedList.Node(1);

        input2Node1.setNext(input2Node2);
        input2Node2.setNext(input2Node3);

        AdditionLinkedList addition = new AdditionLinkedList();
        String result = addition.createStringRepresentation(addition.findSum(input1Node1, input2Node1));
        assertEquals("8,8,8,", result);
    }

    @Test
    public void testFindSum_withCarry() throws Exception {
        AdditionLinkedList.Node input1Node1 = new AdditionLinkedList.Node(5);
        AdditionLinkedList.Node input1Node2 = new AdditionLinkedList.Node(6);

        input1Node1.setNext(input1Node2);

        AdditionLinkedList.Node input2Node1 = new AdditionLinkedList.Node(7);
        AdditionLinkedList.Node input2Node2 = new AdditionLinkedList.Node(5);

        input2Node1.setNext(input2Node2);

        AdditionLinkedList addition = new AdditionLinkedList();
        String result = addition.createStringRepresentation(addition.findSum(input1Node1, input2Node1));
        assertEquals("1,3,1,", result);
    }
}