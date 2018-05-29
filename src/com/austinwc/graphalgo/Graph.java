package com.austinwc.graphalgo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO: Extract interface once stable
//TODO: Isolate the data structures to cut down on coupling to implementation

public class Graph<K, T> {
    private Map<K, Set<K>> edges;
    private Map<K, T> vertices;
    private boolean directed;

    public Graph() {
        this(false);
    }
    public Graph(boolean directed) {
        edges = new HashMap<>();
        vertices = new HashMap<>();
        this.directed = directed;
    }

    public boolean insertEdge(K a, K b) {
        if (!(vertices.containsKey(a) && vertices.containsKey(b))) return false;
        edges.get(a).add(b);
        if (!directed)
            edges.get(b).add(a);
        return true;
    }

    public boolean removeEdge(K a, K b) {
        if (!(vertices.containsKey(a) && vertices.containsKey(b))) return false;
        edges.get(a).remove(b);
        if (!directed)
            edges.get(b).remove(a);
        return true;
    }

    public Set<K> successors(K id) {
        return edges.getOrDefault(id, null);
    }

    public T getVertex(K id) {
        return vertices.getOrDefault(id, null);
    }

    public boolean insertVertex(K id, T field) {
        if (vertices.containsKey(id)) return false;
        vertices.put(id, field);
        edges.put(id, new HashSet<>());
        return true;
    }

    public boolean removeVertex(K id) {
        if (!vertices.containsKey(id)) return false;
        /* Our work is a bit easier if directed
         * We know all references to this node
         */
        if (directed) {
            for (K neighbor : successors(id)) removeEdge(neighbor, id);
        } else {
            for (K node : getNodeIds()) removeEdge(node, id);
        }
        edges.remove(id);
        vertices.remove(id);
        return true;
    }

    public Set<K> getNodeIds() {
        return vertices.keySet();
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        strB.append("Graph:\n");
        for (K id : getNodeIds()) {
            strB.append(getVertex(id));
            strB.append(" -> ");
            for (K neighbor : successors(id)) {
                strB.append(vertices.get(neighbor));
                strB.append(", ");
            }
            strB.append("\n");
        }
        return strB.toString();
    }

    public void printGraph() {
        System.out.println(toString());
    }

    public static Graph<Integer, String> graphFileFactory(String fileName) {
        return null;
    }

}
