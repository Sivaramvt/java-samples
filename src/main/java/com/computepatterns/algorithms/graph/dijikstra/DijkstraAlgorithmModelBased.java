package com.computepatterns.algorithms.graph.dijikstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.computepatterns.algorithms.graph.model.Edge;
import com.computepatterns.algorithms.graph.model.Graph;
import com.computepatterns.algorithms.graph.model.Vertex;

/**
 * Finding the shortest path between source and all other nodes.
 * Implementation based on Java POJO (Model) objects.
 * @see <a href="http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html">Adaptation from vogella.com</a>
 * Java 8 based implementation.
 */
public class DijkstraAlgorithmModelBased {

    /** Copy of the nodes of the given graph */
    private final List<Vertex> nodes;
    /** Copy of the edges of the given graph */
    private final List<Edge> edges;
    /** Vertex for which the shortest distance from source has been found and part of shortest path tree (SPT)*/
    private Set<Vertex> settledNodes;
    /** Vertex for which distance is found but yet to be a part of SPT. */
    private Set<Vertex> unSettledNodes;
    /** Map holds the path details */
    private Map<Vertex, Vertex> predecessors;
    /** Holds the distance of every vertex from the source */
    private Map<Vertex, Integer> distance;

    public DijkstraAlgorithmModelBased(Graph graph) {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<Vertex>(graph.getVertexes());
        this.edges = new ArrayList<Edge>(graph.getEdges());

        predecessors = new HashMap<Vertex, Vertex>();

        // Settled and unsettled nodes are empty.
        settledNodes = new HashSet<Vertex>();
        unSettledNodes = new HashSet<Vertex>();

        // Initialize distance.
        // Set all distance to infinity.
        distance = new HashMap<Vertex, Integer>(nodes.size());
        for(Vertex vertex: this.nodes){
            distance.put(vertex, Integer.MAX_VALUE);
        }

    }

    public void execute(Vertex source) {
        // Distance of source from source is 0.
        distance.put(source, 0);
        unSettledNodes.add(source);

        // Run till no nodes present in unsettled nodes.
        while (unSettledNodes.size() > 0) {

            // Get the vertex with minimum distance from unsettled nodes.
            Vertex node = getMinimum(unSettledNodes);

            // Marking the vertex as settled.
            settledNodes.add(node);
            unSettledNodes.remove(node);

            // Find distances of adjacent vertices.
            computeNeighborsDistances(node);
        }
    }

    /**
     * Get the node with minimum distance from the unsettled nodes.
     */
    private Vertex getMinimum(Set<Vertex> vertexes) {
        // Use of Java 8 Optional container object.
        Optional<Vertex> minimum = Optional.empty();
        for (Vertex vertex : vertexes) {
            if (!minimum.isPresent()) {
                minimum = Optional.of(vertex);
            } else {
                if (distance.get(vertex) < distance.get(minimum.get())) {
                    minimum = Optional.of(vertex);
                }
            }
        }

        return minimum.get();
    }

    private void computeNeighborsDistances(Vertex node) {
        List<Vertex> adjacentNodes = getNeighbors(node);

        adjacentNodes.stream()
                .filter(target -> distance.get(target) > distance.get(node) + getDistance(node, target))
                .forEach(target -> {
                    distance.put(target, distance.get(node) + getDistance(node, target));
                    // Marking the predecessor for tracking paths.
                    predecessors.put(target, node);
                    // Adding it unsettled.
                    unSettledNodes.add(target);
                });
    }

    private int getDistance(Vertex node, Vertex target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    /**
     * Finding the neighbors of the current node.
     * @param node
     * @return
     */
    private List<Vertex> getNeighbors(Vertex node) {
        return edges.stream()
                .filter( edge ->edge.getSource().equals(node) && !settledNodes.contains(edge.getDestination()))
                .map(edge -> edge.getDestination())
                .collect(Collectors.toList());
    }


    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
}