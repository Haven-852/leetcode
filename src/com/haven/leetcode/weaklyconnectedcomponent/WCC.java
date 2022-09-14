package com.haven.leetcode.weaklyconnectedcomponent;

import java.util.ArrayList;

public class WCC {
    private final Graph directedGraph;
    public WCC(Graph directedGraph) {
        this.directedGraph = directedGraph;
    }
    // Finds all the connected components of the given undirected graph
    private ArrayList<ArrayList<Integer> > connectedComponents(Graph undirectedGraph) {
        ArrayList<ArrayList<Integer> > connectedComponents = new ArrayList<>();
        boolean[] isVisited = new boolean[undirectedGraph.vertices];
        for (int i = 0; i < undirectedGraph.vertices; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                findConnectedComponent(i, isVisited, component, undirectedGraph);
                connectedComponents.add(component);
            }
        }
        return connectedComponents;
    }
    // Finds a connected component
    // starting from source using DFS
    private void findConnectedComponent(int src, boolean[] isVisited, ArrayList<Integer> component, Graph undirectedGraph) {
        isVisited[src] = true;
        component.add(src);
        for (int v : undirectedGraph.adjacencyList.get(src))
            if (!isVisited[v])
                findConnectedComponent(v, isVisited, component, undirectedGraph);
    }
    public ArrayList<ArrayList<Integer> > weaklyConnectedComponents() {
        // Step 1: Construct the underlying undirected graph
        Graph undirectedGraph = new Graph(directedGraph.vertices);
        for (int u = 0; u < directedGraph.vertices; u++) {
            for (int v : directedGraph.adjacencyList.get(u)) {
                undirectedGraph.addEdge(u, v);
                undirectedGraph.addEdge(v, u);
            }
        }
        // Step 2: Find the connected components of the undirected graph
        return connectedComponents(undirectedGraph);
    }
}
