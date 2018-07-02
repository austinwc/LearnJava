package com.austinwc.graphalgo;

public class GraphAlgoTest {
    public static void main(String[] args) {
        Graph<Integer, Character> testG = new Graph<>();
        testG.insertVertex(1, 'a');
        testG.insertVertex(2, 'b');
        testG.insertVertex(3, 'c');
        testG.insertVertex(4, 'd');
        testG.insertEdge(1, 2);
        testG.insertEdge(2, 3);
        testG.insertEdge(4, 1);
        testG.insertEdge(4, 3);
        testG.insertEdge(4, 2);

        testG.printGraph();

        testG.removeVertex(2);

        testG.printGraph();
    }
}
