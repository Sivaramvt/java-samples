package com.computepatterns.algorithms.graph.bridgefinding;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang.ArrayUtils;

import com.computepatterns.algorithms.graph.model.UndirectedEdge;
import com.computepatterns.algorithms.graph.model.UndirectedGraph;
import com.computepatterns.algorithms.graph.model.Vertex;

/**
 * Depth first search for directed graph.
 * Follows the depth first traversal.
 * Similar to implementation in tree but graph may have cycles.
 * Stack or recursion can be used. Here stack is used.
 *
 * @see <a href="http://www.computepatterns.com/algorithms/graph/depth-first-search-in-graph/">Depth First Search Java</a>
 */
public class BridgeFinding {
    private static int time = 0;
    /**
     * Input graph
     */
    private UndirectedGraph graph;

    private Map<Vertex,Integer> vertexDiscoveredTime = new HashMap<>();
    private Map<Vertex, Integer> lowestDiscoveredTime = new HashMap<>();

    public BridgeFinding(UndirectedGraph graph) {
        this.graph = graph;
    }

    public static void main(String[] args) {

        /* List<Vertex> vertices = new ArrayList<>();
        Vertex vertexA = new Vertex("A", "A");
        vertexA.setValue(5);
        vertices.add(vertexA);

        Vertex vertexB = new Vertex("B", "B");
        vertexB.setValue(10);
        vertices.add(vertexB);

        Vertex vertexC = new Vertex("C", "C");
        vertexC.setValue(15);
        vertices.add(vertexC);

        Vertex vertexD = new Vertex("D", "D");
        vertexD.setValue(20);
        vertices.add(vertexD);

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge("1", vertexA, vertexB, 0 ));
        edges.add(new Edge("1", vertexB, vertexD, 0 ));
        edges.add(new Edge("1", vertexA, vertexC, 0 ));
        edges.add(new Edge("1", vertexC, vertexD, 0 ));
        */


        //Input graph - http://d1gjlxt8vb0knt.cloudfront.net//wp-content/uploads/DFS.jpg
        // Above pic with added edge from vertex 3 - vertex 4 (new one).

        List<Vertex> vertices = new ArrayList<>();
        Vertex v0 = new Vertex("0","0");
        v0.setValue(0);
        vertices.add(v0);
        Vertex v1 = new Vertex("1", "1");
        v1.setValue(1);
        vertices.add(v1);
        Vertex v2 = new Vertex("2", "2");
        v2.setValue(2);
        vertices.add(v2);
        Vertex v3 = new Vertex("3", "3");
        vertices.add(v3);
        v3.setValue(3);
        Vertex v4 = new Vertex("4", "4");
        vertices.add(v4);
        v4.setValue(4);
        Vertex v5 = new Vertex("5", "5");
        vertices.add(v5);
        v5.setValue(5);
        Vertex v6 = new Vertex("6", "6");
        vertices.add(v6);
        v6.setValue(6);

        List<UndirectedEdge> edges = new ArrayList<>();
        UndirectedEdge e0 = new UndirectedEdge("0", v0, v1, 0);
        edges.add(e0);
        UndirectedEdge e1 = new UndirectedEdge("0", v1, v2, 0);
        edges.add(e1);
        UndirectedEdge e2 = new UndirectedEdge("0", v2, v0, 0);
        edges.add(e2);
        UndirectedEdge e3 = new UndirectedEdge("0", v1, v4, 0);
        edges.add(e3);
        UndirectedEdge e4 = new UndirectedEdge("0", v1, v3, 0);
        edges.add(e4);
        UndirectedEdge e5 = new UndirectedEdge("0", v5, v3, 0);
        edges.add(e5);
        UndirectedEdge e6 = new UndirectedEdge("0", v4, v5, 0);
        edges.add(e6);
        UndirectedEdge e7 = new UndirectedEdge("0", v1, v6, 0);
        edges.add(e7);
        /*Edge e5 = new Edge("0", v3, v3, 0);
        edges.add(e5);
        Edge e6 = new Edge("0", v3, v4, 0);
        edges.add(e6);*/

        UndirectedGraph graph = new UndirectedGraph(vertices, edges);
        try {
            Vertex vertex = new BridgeFinding(graph).findVertex(v0, 1);
            System.out.printf("Search key found in vertex - %s", vertex.getId());

        } catch (VertexNotFound vertexNotFound) {
            vertexNotFound.printStackTrace();
        }
    }

    /**
     * Find the vertex which has the given search key
     * @param startingNode Starting vertex for traversal.
     * @param searchValue Search key
     * @return The vertext with the value.
     * @throws VertexNotFound When search key is not found.
     */
    public Vertex findVertex(Vertex startingNode, int searchValue) throws VertexNotFound{

        Stack<Vertex> stack = new Stack<>();
        stack.push(startingNode);
        int[] parent = new int[10];

        while(!stack.isEmpty()){
            Vertex currentNode = stack.pop();
            // Mark the traversed node to deal with cycles.
            currentNode.setVisited(true);

            // If vertex is discovered first time, assign time to it.
            int test = ++time;
            vertexDiscoveredTime.put(currentNode, test);
            lowestDiscoveredTime.put(currentNode, test);

            for(Vertex vertex :findNeighbors(currentNode)){
                if(!vertex.isVisited())
                {
                    parent[vertex.getValue()] = currentNode.getValue();
                    stack.push(vertex);


                    if(lowestDiscoveredTime.containsKey(currentNode) && lowestDiscoveredTime.containsKey(vertex)) {
                        lowestDiscoveredTime.put(currentNode, Math.min(lowestDiscoveredTime.get(currentNode), lowestDiscoveredTime.get(vertex)));
                    }else if(lowestDiscoveredTime.containsKey(currentNode) && !lowestDiscoveredTime.containsKey(vertex)){
                        lowestDiscoveredTime.put(currentNode,lowestDiscoveredTime.get(currentNode));
                    } else{
                        lowestDiscoveredTime.put(currentNode,lowestDiscoveredTime.get(vertex));
                    }

                    if(lowestDiscoveredTime.containsKey(vertex) && lowestDiscoveredTime.get(vertex) > vertexDiscoveredTime.get(currentNode)){
                        System.out.println("Bridge for edge " + currentNode.getId() + "-" + vertex.getId());
                    }


                }else if(vertex.getValue() != parent[currentNode.getValue()]) {
                    if(lowestDiscoveredTime.containsKey(currentNode) && vertexDiscoveredTime.containsKey(vertex))
                        lowestDiscoveredTime.put(currentNode, Math.min(lowestDiscoveredTime.get(currentNode), vertexDiscoveredTime.get(vertex)));
                    else if (lowestDiscoveredTime.containsKey(currentNode) && !vertexDiscoveredTime.containsKey(vertex)){
                        lowestDiscoveredTime.put(currentNode, lowestDiscoveredTime.get(currentNode));
                    }else
                        lowestDiscoveredTime.put(currentNode, vertexDiscoveredTime.get(vertex));
                }





            }


        }
        throw new VertexNotFound("Vertex with search key is not found.");
    }

    /**
     * Find the neighbors of the current vertex.
     * @param currentNode
     * @return
     */
    private List<Vertex> findNeighbors(Vertex currentNode) {
        return graph.getEdges().stream().filter(edge -> ArrayUtils.contains(edge.getVertices(), currentNode))
                .map(edge -> {
                    return Arrays.stream(edge.getVertices()).filter(vertex -> !vertex.equals(currentNode)).findFirst().get();
                }).collect(Collectors.toCollection(ArrayList::new));

    }

    /**
     * Exception thrown when the search key is not found.
     */
    class VertexNotFound extends Exception{
        VertexNotFound(String msg){
            super(msg);
        }
    }
}
