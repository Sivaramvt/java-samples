package com.computepatterns.datastructures.binarytree;

/**
 * Binary tree utilities.
 */
public class BinaryTreeUtils extends AbstractBinaryTree {
    public BinaryTreeUtils(Node rootNode) {
        super(rootNode);
    }

    /**
     * Check if 2 trees are identical.
     * They are identical if the structure and the content are same.
     * @param rootTree1
     * @param rootTree2
     * @return True if yes.
     */
    public boolean areIdentical(Node rootTree1, Node rootTree2){
        /* If both the nodes are null, then they are identical */
        if(null == rootTree1 || null == rootTree2){
            return true;
        }

        /* If one of them is null but not both, then they are not identical */
        if(null == rootTree1 || null == rootTree2){
            return false;
        }

        /* If 2 nodes value are same, and their left/right children values are same, then they are identical */
        return rootTree1.getValue() == rootTree2.getValue()
                && areIdentical(rootTree1.getLeft(), rootTree2.getRight())
                && areIdentical(rootTree1.getLeft(), rootTree2.getRight());
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

        /* Diameter of left and right trees */
        int leftDiameter = computeDiameter(root.getLeft());
        int rightDiameter = computeDiameter(root.getRight());

        /* Diameter of the given node is the max of the sum of heights plus one or the right/left diameter. */
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }
}
