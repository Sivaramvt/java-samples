package com.computepatterns.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.computepatterns.algorithms.graph.model.Edge;
import com.computepatterns.algorithms.graph.model.Graph;
import com.computepatterns.algorithms.graph.model.Vertex;

/**
 * Breadth first search for directed graph.
 * Follows the breadth first traversal.
 * Similar to implementation in tree but graph may have cycles.
 * Queue is used.
 * Implementation similar to {@link DepthFirstSearch Depth First Search } except the stack is replaced with queue.
 *
 * Time complexity - O(V+E)
 *
 * @see <a href="http://www.computepatterns.com/algorithms/graph/breadth-first-search-in-graph/">Breadth first search algorithm java</a></a>
 */
public class BreadFirstSearch {
    /**
     * Exception thrown when the search key is not found.
     */
    class VertexNotFound extends Exception{
        VertexNotFound(String msg){
            super(msg);
        }
    }

    /**
     * Input graph
     */
    private Graph graph;

    public BreadFirstSearch(Graph graph) {
        this.graph = graph;
    }

    /**
     * Find the vertex which has the given search key
     * @param startingNode Starting vertex for traversal.
     * @param searchValue Search key
     * @return The vertext with the value.
     * @throws VertexNotFound When search key is not found.
     */
    public Vertex findVertex(Vertex startingNode, int searchValue) throws VertexNotFound{

        LinkedList<Vertex> queue = new LinkedList<>();
        queue.add(startingNode);

        while(!queue.isEmpty()){
           Vertex currentNode = queue.poll();
            // Mark the traversed node to deal with cycles.
            currentNode.setVisited(true);
            System.out.println(currentNode.getName());

            if(currentNode.getValue() == searchValue){
                return  currentNode;
            }

           for(Vertex vertex :findNeighbors(currentNode)){
               if(!vertex.isVisited())
               queue.add(vertex);
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
        return graph.getEdges().stream().filter(edge -> edge.getSource().equals(currentNode))
                .map(edge -> edge.getDestination()).collect(Collectors.toCollection(ArrayList::new));
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


        //Input graph - http://d1gjlxt8vb0knt.cloudfront.net//wp-content/uploads/BFS.jpg
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

        List<Edge> edges = new ArrayList<>();
        Edge e0 = new Edge("0", v0, v1, 0);
        edges.add(e0);
        Edge e1 = new Edge("0", v0, v2, 0);
        edges.add(e1);
        Edge e2 = new Edge("0", v2, v0, 0);
        edges.add(e2);
        Edge e3 = new Edge("0", v1, v2, 0);
        edges.add(e3);
        Edge e4 = new Edge("0", v2, v3, 0);
        edges.add(e4);
        Edge e5 = new Edge("0", v3, v3, 0);
        edges.add(e5);
        Edge e6 = new Edge("0", v3, v4, 0);
        edges.add(e6);

        Graph graph = new Graph(vertices, edges);
        try {
            Vertex vertex = new BreadFirstSearch(graph).findVertex(v2, 1);
            System.out.printf("Search key found in vertex - %s", vertex.getId());

        } catch (VertexNotFound vertexNotFound) {
            vertexNotFound.printStackTrace();
        }
    }
}
