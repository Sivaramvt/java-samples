package com.computepatterns.datastructures.binarysearchtree;

import com.computepatterns.datastructures.binarytree.AbstractBinaryTree;

/**
 * Check if the given tree is a binary search tree
 */
public class BSTTest extends AbstractBinaryTree{
    public BSTTest(Node rootNode) {
        super(rootNode);
    }

    public static void main(String[] args) {

        /* Test 1 - Positive case */
        // Visual - http://geeksforgeeks.org/wp-content/uploads/2009/11/BST.gif
        BSTOperations.Node node1 = new BSTOperations.Node(1, null, null);
        BSTOperations.Node node3 = new BSTOperations.Node(3, null, null);
        BSTOperations.Node node5 = new BSTOperations.Node(5, null, null);
        BSTOperations.Node node2 = new BSTOperations.Node(2, node1, node3);
        BSTOperations.Node node4 = new BSTOperations.Node(4, node2, node5);

        // Start with a broader range.
        System.out.println(new BSTTest(node4).checkIfBST(node4, Integer.MIN_VALUE, Integer.MAX_VALUE));

        /* Test 2 - Negative case */
        // Visual - http://geeksforgeeks.org/wp-content/uploads/2009/11/tree_bst.gif
        BSTOperations.Node anode1 = new BSTOperations.Node(1, null, null);
        BSTOperations.Node anode4 = new BSTOperations.Node(4, null, null);
        BSTOperations.Node anode5 = new BSTOperations.Node(5, null, null);
        BSTOperations.Node anode2 = new BSTOperations.Node(2, anode1,anode4);
        BSTOperations.Node anode3 = new BSTOperations.Node(3, anode2, node5);

        System.out.println(new BSTTest(anode3).checkIfBST(anode3, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    /**
     * Check if the given tree is a BST.
     * <p>
     *     Maintains a range for which the value of the node has to fall within to stay as BST.
     *     This range is verified and revised at every node.
     * </p>
     * @param root
     * @param rangeMin
     * @param rangeMax
     * @return
     */
    public boolean checkIfBST(Node root, int rangeMin, int rangeMax){
        /* If root is null, return true as empty tree is a BST */
        if(null == root){
            return true;
        }
        /* Check if the given root's value falls within the range */
        // If outside range stop traversing and return false.
        if(root.getValue() < rangeMin || root.getValue() > rangeMax){
            return false;
        }

        /* Traverse left updating max value of range */
        // Revisit the range
        boolean isLeftTreeBST = checkIfBST(root.getLeft(), rangeMin, root.getValue() - 1);
        //Continue traversing to right only if left tree is BST
        if(!isLeftTreeBST){
            return false;
        }

        /* Traverse right updating min value of value */
        // Revisit the range
        return checkIfBST(root.getRight(), root.getValue() - 1, rangeMax);
    }
}
