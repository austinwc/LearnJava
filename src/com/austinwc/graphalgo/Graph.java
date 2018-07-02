package com.austinwc.graphalgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//TODO: Extract interface once stable
//TODO: Isolate the data structures to cut down on coupling to implementation

public class Graph<K, T> {
    private Map<K, List<EdgeNode>> edges;
    private Map<K, T> vertices;
    private boolean directed;

    public class EdgeNode {
        private K vertexKey;
        private int weight;

        public EdgeNode(K vertex, int weight) {
            vertexKey = vertex;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public K getVertexKey() {
            return vertexKey;
        }
    }

    public Graph() {
        this(false);
    }

    public Graph(boolean directed) {
        edges = new HashMap<>();
        vertices = new HashMap<>();
        this.directed = directed;
    }

    public int size() {
        return vertices.size();
    }

    public boolean insertEdge(K a, K b) {
        return insertEdge(a, b, 1);
    }

    public boolean insertEdge(K a, K b, int weight) {
        if (!(vertices.containsKey(a) && vertices.containsKey(b))) return false;
        edges.get(a).add(new EdgeNode(b, weight));
        if (!directed)
            edges.get(b).add(new EdgeNode(a, weight));
        return true;
    }

    public boolean removeEdge(K a, K b) {
        if (!(vertices.containsKey(a) && vertices.containsKey(b))) return false;

        // Find and remove edge
        List<EdgeNode> adjList = edges.get(a);
        EdgeNode tmp = null;
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).getVertexKey() == b) tmp = adjList.get(i);
        }
        if (tmp == null) return false;
        adjList.remove(tmp);

        // If undirected graph, remove duplicate edge as well
        if (!directed)
            removeEdge(b, a);
        return true;
    }

    public List<EdgeNode> successors(K id) {
        return edges.getOrDefault(id, null);
    }

    public T getVertex(K id) {
        return vertices.getOrDefault(id, null);
    }

    public boolean insertVertex(K id, T field) {
        if (vertices.containsKey(id)) return false;
        vertices.put(id, field);
        edges.put(id, new ArrayList<>());
        return true;
    }

    public boolean removeVertex(K id) {
        if (!vertices.containsKey(id)) return false;
        /* Our work is a bit easier if directed
         * We know all references to this node
         */
        if (directed) {
            for (EdgeNode neighbor : successors(id)) removeEdge(neighbor.getVertexKey(), id);
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
            for (EdgeNode neighbor : successors(id)) {
                strB.append(vertices.get(neighbor.getVertexKey()));
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
