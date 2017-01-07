package com.computepatterns.datastructures.binarytree;

/**
 * Binary tree traversals based on Depth-first & Breadt-first.
 * <p>
 *     Depth-first
 *     * In-Order: Left, Root, Right.
 *     * Pre-Order: Root, Left, Right.
 *     * Post-Order: Left, Right, Root.
 * </p>
 */
public class BinaryTreeTraversals extends AbstractBinaryTree{

    public BinaryTreeTraversals(Node rootNode) {
        super(rootNode);
    }

    public static void main(String[] args) {
        /* Construct tree */
        BinaryTreeTraversals.Node r4 = new BinaryTreeTraversals.Node(4, null, null);
        BinaryTreeTraversals.Node r5 = new BinaryTreeTraversals.Node(5, null, null);
        BinaryTreeTraversals.Node r3 = new BinaryTreeTraversals.Node(3, null, null);
        BinaryTreeTraversals.Node r2 = new BinaryTreeTraversals.Node(2,r4,r5);
        BinaryTreeTraversals.Node r1 = new BinaryTreeTraversals.Node(1,r2,r3);

        BinaryTreeTraversals tree = new BinaryTreeTraversals(r1);
        tree.traverseInOrder(r1);
    }

    /**
     * Breadth first - InOrder traversal (Left, Root, Right).
     * @param node
     */
    public void traverseInOrder(Node node){
        if(null == node){
            return;
        }

        /* Recur left */
        traverseInOrder(node.getLeft());

        /* Visit root */
        System.out.print(node.getValue());

        /* Rcur right */
        traverseInOrder(node.getRight());
    }

}
