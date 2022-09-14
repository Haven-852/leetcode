package com.haven.leetcode.weaklyconnectedcomponent;

import java.util.ArrayList;

public class WCCdemo {
    public static void main(String[] args) {
        Graph directedGraph = new Graph(6);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(3, 1);
        directedGraph.addEdge(3, 2);
        directedGraph.addEdge(4, 5);
        ArrayList<ArrayList<Integer>> weaklyConnectedComponents = new WCC(directedGraph).weaklyConnectedComponents();
        int index = 1;
        for (ArrayList<Integer> component : weaklyConnectedComponents) {
            System.out.print("Component " + index++ + ": ");
            for (Integer i : component)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
