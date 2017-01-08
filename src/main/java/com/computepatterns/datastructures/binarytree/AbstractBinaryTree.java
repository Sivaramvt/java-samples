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
}
