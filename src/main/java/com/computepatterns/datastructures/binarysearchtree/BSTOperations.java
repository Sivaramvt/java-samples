package com.computepatterns.datastructures.binarysearchtree;

import com.computepatterns.datastructures.binarytree.AbstractBinaryTree;
import com.computepatterns.datastructures.binarytree.BinaryTreeTraversals;

/**
 * Binary Search Tree (BST) is a binary tree with the left node always less than the root and the
 * right greater than the root.
 */
public class BSTOperations extends AbstractBinaryTree{
    public BSTOperations(Node rootNode) {
        super(rootNode);
    }

    public static void main(String[] args) {
        /* Visual of tree - http://quiz.geeksforgeeks.org/wp-content/uploads/2014/01/200px-Binary_search_tree.svg_.png */
        BSTOperations.Node node4 = new BSTOperations.Node(4, null, null);
        BSTOperations.Node node7 = new BSTOperations.Node(7, null, null);
        BSTOperations.Node node13 = new BSTOperations.Node(13, null, null);
        BSTOperations.Node node1 = new BSTOperations.Node(1, null, null);
        BSTOperations.Node node6 = new BSTOperations.Node(6, node4, node7);
        BSTOperations.Node node14 = new BSTOperations.Node(14, node13, null);
        BSTOperations.Node node3 = new BSTOperations.Node(3, node1, node6);
        BSTOperations.Node node10 = new BSTOperations.Node(10, null, node14);
        BSTOperations.Node node8 = new BSTOperations.Node(8, node3, node10);

        /* BST search */
        Node keyNode = new BSTOperations(node8).search(node8, 6);
        if(null != keyNode){
            System.out.println("Key found");
        }else{
            System.out.println("Key NOT found.");
        }

        /* Insert node*/
        System.out.println(System.getProperty("line.separator"));
        System.out.println("----Inserting node----");
        System.out.println("Before - ");
        new BinaryTreeTraversals(node8).traverseInOrder(node8);
        new BSTOperations(node8).insertNode(node8, 11);
        System.out.println("\nAfter -");
        new BinaryTreeTraversals(node8).traverseInOrder(node8);

        /* Insert node*/
        System.out.println(System.getProperty("line.separator"));
        System.out.println("----Deleting node----");
        System.out.println("Before - ");
        new BinaryTreeTraversals(node8).traverseInOrder(node8);
        System.out.println("\nAfter - Deleting 11 ");
        new BSTOperations(node8).deleteNode(node8, 11);
        new BinaryTreeTraversals(node8).traverseInOrder(node8);
        System.out.println("\nAfter - Deleting 14 ");
        new BSTOperations(node8).deleteNode(node8, 14);
        new BinaryTreeTraversals(node8).traverseInOrder(node8);
        System.out.println("\nAfter - Deleting 6 ");
        new BSTOperations(node8).deleteNode(node8, 6);
        new BinaryTreeTraversals(node8).traverseInOrder(node8);

        /* Find minimum value in a BST */
        System.out.println(System.getProperty("line.separator"));
        System.out.println("----Minimum value----");
        System.out.println(new BSTOperations(node8).findMinValue(node8).getValue());

        /* Find minimum value in a BST */
        System.out.println(System.getProperty("line.separator"));
        System.out.println("----Find successor----");
        System.out.println(new BSTOperations(node8).findSuccessor(node8, 3).getValue());

        /* Find minimum value in a BST */
        System.out.println(System.getProperty("line.separator"));
        System.out.println("----Find predecessor----");
        System.out.println(new BSTOperations(node8).findPredecessor(node8, 3).getValue());
    }

    /**
     * Search in binary search tree.
     * Time complexity - O(h), h being height of the tree.
     * @param root
     * @param key
     * @return
     */
    public Node search(Node root, int key){
        /* If node null return null */
        if(null == root){
            return null;
        }
        /* Compare the key with the node */
        if(key == root.getValue()){
            return root;
        }
        /* If key is less than node's value, continue search in left tree */
        if(key < root.getValue()){
            return  search(root.getLeft(), key);
        }
        /* If key is greater than node's value, continue search in right tree */
        return search(root.getRight(), key);
    }

    /**
     * Insert node into a BST.
     * Time complexity - O(h), h being the height of the tree.
     * @param root
     * @param value
     * @return
     */
    public Node insertNode(Node root, int value){
        /* If the node is leaf, then create a node and attach */
        if(null == root){
            return new Node(value, null, null);
        }
        /* Traverse to the leaf node*/
        if(value < root.getValue()){
            root.setLeft(insertNode(root.getLeft(), value));;
        }else if(value > root.getValue()) {
            root.setRight(insertNode(root.getRight(), value));
        }

        return  root;
    }

    /**
     * Deleting a node from BST.
     * @param root
     * @param value
     * @return
     */
    public Node deleteNode(Node root, int value){
        /* If root is null, return null */
        if(null == root){
            return null;
        }
        /* Traverse till the required key is hit */
        if(value > root.getValue()){
            root.setRight(deleteNode(root.getRight(), value));
        }else if(value < root.getValue()){
            root.setLeft(deleteNode(root.getLeft(), value));
        }else {
            /* case - Found the key */
            // If it's leaf node, return null
            if(null == root.getLeft() && null == root.getRight()){
                return null;
            }
            // If it has one child, return that
            else if(null == root.getLeft() || null == root.getRight()){
                if(null == root.getLeft()){
                    return root.getRight();
                }else{
                    return root.getLeft();
                }
            }
            // If it has 2 children, find the successor node
            else{
                Node successor = findSuccessor(root, value);
                root.setValue(successor.getValue());
                successor.setValue(value);
                root.setRight(deleteNode(root.getRight(), successor.getValue()));
            }
        }
        return root;
    }

    /**
     * Find the minimum value node in a BST
     * @param root
     * @return
     */
    public Node findMinValue(Node root){

        /* If root's left is available, keep traversing till the leaf and that's the minimum */
        if(null != root && null != root.getLeft()){
            return findMinValue(root.getLeft());
        }else {
            return root;
        }
    }

    /**
     * Find successor.
     * <p>
     *     Successor of a node is the node which carries the value that is next big to the given node in the BST.
     * </p>
     * @param root
     * @param key
     * @return
     */
    public Node findSuccessor(Node root, int key){
        /* If root is null, return null */
        if(null == root){
            return null;
        }

        Node successor = null;
        /* If root has the intended key, then find successor */
        if(key == root.getValue()){

        /* Successor is the smallest node in the right tree of the given root */
            successor = root.getRight();
            while(null != successor.getLeft()){
                successor = successor.getLeft();
            }
            return successor;
        }
        /* Traverse left */
        successor = findSuccessor(root.getLeft(), key);
        if(null != successor){
            return successor;
        }
        /* Traverse right */
        successor = findSuccessor(root.getRight(), key);
        return successor;
    }


    /**
     * Find Predecessor of the given node.
     * <p>
     *     Predecessor of a node is the node which carries the value that is next less to the given node in the BST.
     * </p>
     * @param root
     * @param key
     * @return
     */
    public Node findPredecessor(Node root, int key){
        /* If root is null, return null */
        if(null == root){
            return null;
        }

        Node predecessor = null;
        /* If root has the intended key, then find successor */
        if(key == root.getValue()){

        /* Predessor is the largest node in the left tree of the given root */
            predecessor = root.getLeft();
            while(null != predecessor && null != predecessor.getRight()){
                predecessor = predecessor.getRight();
            }
            return predecessor;
        }
        /* Traverse left */
        predecessor = findPredecessor(root.getLeft(), key);
        if(null != predecessor){
            return predecessor;
        }
        /* Traverse right */
        predecessor = findPredecessor(root.getRight(), key);
        return predecessor;
    }
}
