package com.computepatterns.algorithms.graph;

/**
 * Floyd warshall shortest path algorithm to find the shortest distance between every pair of nodes.
 * This works for directed weighed graph. Allows negative weights without cycle.
 * Time complexity - O(V^3) - Cubic time / Expensive.
 * Flyod algotithm is based on dynamic programming is a method for solving a complex problem by
 * breaking it down into a collection of simpler sub problems, solving each of those subproblems
 * just once, and storing their solutions – ideally, using a memory-based data structure.
 *
 * @see <a href="http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/>Geek for Geek</a>
 */
public class FloydShortestPath {
    private static final int INF = 9999;

    /**'
     * Compute shortest distance for every pair of nodes in the given graph.
     *
     * @return Graph representing the shortest distance between nodes.
     */
    public int[][] computeShortestPath(int[][] graph) {
        int[][] computedDistances = new int[graph.length][graph.length];


        // Initialize with the given graph.
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                computedDistances[i][j] = graph[i][j];
            }
        }

        int noOfNodes = graph.length;
        for (int k = 0; k < noOfNodes; k++){
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if(computedDistances[i][k] + computedDistances[k][j] < computedDistances[i][j]){
                        computedDistances[i][j] = computedDistances[i][k] + computedDistances[k][j];
                    }
                }
            }
        }
        return  computedDistances;
    }

    public static void printGraph(int graph[][])
    {
        for (int i=0; i<graph.length; ++i)
        {
            for (int j=0; j<graph[i].length; ++j)
            {
                if (graph[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int inputGraph[][] = {  {0,   5,  INF, 10},
                                {INF, 0, 3, INF},
                                {INF, INF, 0,   1},
                                {INF, INF, INF, 0}
                            };
        printGraph(new FloydShortestPath().computeShortestPath(inputGraph));
    }
}
