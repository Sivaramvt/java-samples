package com.computepatterns.datastructures.binarytree;

/**
 * Binary tree traversals based on Depth-first & Breadth-first.
 * <p>
 *     Depth-first
 *     * In-Order: Left, Root, Right.
 *     * Pre-Order: Root, Left, Right.
 *     * Post-Order: Left, Right, Root.
 *     Breadth-first
 *     * Level-Order - Go level by level.
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
        System.out.println("InOrder traversal");
        tree.traverseInOrder(r1);

        System.out.println(System.getProperty("line.separator"));
        System.out.println("PreOrder traversal");
        tree.traversePreOrder(r1);

        System.out.println(System.getProperty("line.separator"));
        System.out.println("PostOrder traversal");
        tree.traversePostOrder(r1);

        System.out.println(System.getProperty("line.separator"));
        System.out.println("LevelOrder traversal");
        tree.traverseLevelOrder(r1);
    }

    /**
     * Breadth first - InOrder traversal (Left, Root, Right).
     * Time complexity - O(n)
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

    /**
     * Depth first pre order traversal (Root, Left, Right).
     * Time complexity - O(n)
     * <p>
     *     Used in polish notation.
     * </p>
     * @param node
     */
    public void traversePreOrder(Node node){
        if(null == node){
            return;
        }

        /* Visit root first */
        System.out.print(node.getValue());

        /* Recur left */
        traversePreOrder(node.getLeft());

        /* Recur right */
        traversePreOrder(node.getRight());
    }

    /**
     * Depth first post order tarversal (Left, Right, Root).
     * Time complexity - O(n)
     * @param node
     */
    public void traversePostOrder(Node node){
        if(null == node){
            return;
        }

        /* Recur left node first */
        traversePostOrder(node.getLeft());

        /* Recur right node */
        traversePostOrder(node.getRight());

        /* Visit the root node */
        System.out.print(node.getValue());
    }

    /**
     * BreadthFirst - Level order traversal. Traverse level by level.
     * Time Complexity - Worst case O(n^2)
     * @param root
     */
    public void traverseLevelOrder(Node root){
        int treeHeight = computeHeight(root);
        for(int i = 1; i <= treeHeight; i++){
            printNodesInLevel(root, i);
        }
    }

    /**
     * Print the nodes in the given lebel.
     * @param node
     * @param level
     */
    private void printNodesInLevel(Node node, int level){

        /* Return if node is null */
        if(null == node){
            return;
        }
        /* Print the value of node if level is 1 */
        if(1 == level){
            System.out.print(node.getValue());
        }
        /* If level > 1, recur left and right till it reaches the level. */
        else{
            printNodesInLevel(node.getLeft(), level - 1);
            printNodesInLevel(node.getRight(), level - 1);
        }
    }
}
