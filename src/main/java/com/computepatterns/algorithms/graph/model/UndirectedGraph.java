package com.computepatterns.algorithms.graph.model;

import java.util.List;

/**
 * Represents Undirected Graph. Made of Vertices and Undirected Edges.
 */
public class UndirectedGraph {
    private final List<Vertex> vertexes;
    private final List<UndirectedEdge> edges;

    public UndirectedGraph(List<Vertex> vertexes, List<UndirectedEdge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<UndirectedEdge> getEdges() {
        return edges;
    }
}