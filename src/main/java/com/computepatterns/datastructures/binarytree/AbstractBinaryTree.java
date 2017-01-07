package com.computepatterns.datastructures.binarytree;

/**
 * Defines Binary tree
 */
public abstract class AbstractBinaryTree {
    protected Node rootNode;

    public AbstractBinaryTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * Represents node in binary tree.
     */
    protected static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public int getValue(){
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
