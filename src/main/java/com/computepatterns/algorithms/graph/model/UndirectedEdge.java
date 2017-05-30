package com.computepatterns.algorithms.graph.model;

/**
 * Undirected edge connecting the <code>Vertex</code>
 */
public class UndirectedEdge {
    private final String id;
    private final Vertex vertex1;
    private final Vertex vertex2;
    private final int weight;

    public UndirectedEdge(String id, Vertex vertex1, Vertex vertex2, int weight) {
        this.id = id;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getWeight() {

        return weight;
    }

    public Vertex[] getVertices(){
        return new Vertex[]{vertex1, vertex2};
    }

    @Override
    public String toString() {
        return vertex1 + " " + vertex2;
    }
}