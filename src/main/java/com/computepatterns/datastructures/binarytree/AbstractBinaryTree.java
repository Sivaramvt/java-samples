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

        public void setValue(int value) {
            this.value = value;
        }

        private Node right;

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

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

    /**
     * Find the height of the binary tree given the root node.
     * @param root
     * @return Height of the longest path.
     */
    protected int computeHeight(Node root){
        if(null == root){
            return 0;
        }

        int leftHeight = computeHeight(root.getLeft());
        int rightHeight = computeHeight(root.getRight());

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * Diameter of a tree is the number of nodes on the longest path between 2 leaves in the tree.
     * @param root
     * @return
     */
    protected int computeDiameter(Node root){
        if(null == root){
            return 0;
        }

        /* Height of left and right trees */
        int leftHeight = computeHeight(root.getLeft());
        int rightHeight = computeHeight(root.getRight());

        /* Diamter of left and right trees */
        int leftDiameter = computeDiameter(root.getLeft());
        int rightDiameter = computeDiameter(root.getRight());

        /* Diamter of the given node is the max of the sum of heights plus one or the right/left diameter. */
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }
}
