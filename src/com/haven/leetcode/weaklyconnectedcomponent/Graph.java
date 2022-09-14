package com.haven.leetcode.weaklyconnectedcomponent;

import java.util.ArrayList;

public class Graph {
    int vertices;
    ArrayList<ArrayList<Integer>> adjacencyList;
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < this.vertices; i++)
            adjacencyList.add(new ArrayList<>());
    }
    public void addEdge(int u, int v) {
        // Use of noEdge(int, int)
        // prevents duplication of edges
        if (noEdge(u, v))
            adjacencyList.get(u).add(v);
    }
    // Returns true if there does NOT exist
    // any edge from u to v
    boolean noEdge(int u, int v) {
        for (int destination : adjacencyList.get(u))
            if (destination == v)
                return false;
        return true;
    }
}
