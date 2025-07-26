package com.srvivek.dsalgo.queue.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchApp {

    public static void main(String[] args) {

        // Number of vertices in the graph
        int vertices = 6;

        // An ArrayList<Integer> to store all the nodes (int position) connected to present node.
        final List<List<Integer>> adjacecyList = new ArrayList<>(6);

        //Initialize the arrayList
        for (int i = 0; i <= vertices; i++) adjacecyList.add(i, new ArrayList<>());

        // Add node connections (edges)
        addEdge(adjacecyList, 0, 1);
        addEdge(adjacecyList, 0, 2);
        addEdge(adjacecyList, 1, 3);
        addEdge(adjacecyList, 1, 4);
        addEdge(adjacecyList, 2, 4);
        System.out.println("Data : " + adjacecyList);
        System.out.println("Data size : " + adjacecyList.size());

        int startNode = 0;
        breadFirstSearch(adjacecyList, startNode);
    }

    /**
     * Traverse all the connected nodes starting from given node in the graph.
     *
     * @param adjacecyList
     * @param sourceNode
     */
    private static void breadFirstSearch(List<List<Integer>> adjacecyList, int sourceNode) {

        final boolean[] visitTracker = new boolean[adjacecyList.size()];
        final Queue<Integer> queue = new LinkedList<>();

        // mark source as visited
        visitTracker[sourceNode] = true;

        // add current node in queue
        queue.add(sourceNode);

        while (!queue.isEmpty()) {
            // get the Node (int) from the queue
            Integer t = queue.poll();
            System.out.println("Node : " + t);

            for (int node : adjacecyList.get(t)) {
                if(!visitTracker[node]) {
                    System.out.println("  Processing node : " + node);
                    visitTracker[node] = true;
                    System.out.println("  Visited: " + node);
                    queue.add(node);
                } else {
                    System.out.println("  Skipping visited node : " + node);
                }
            }
            System.out.println("Queue : " + queue.toString());
        }
    }

    /**
     * Add the edge link in the list.
     *
     * @param adjacecyList
     * @param u
     * @param v
     */
    private static void addEdge(List<List<Integer>> adjacecyList, int u, int v) {
        adjacecyList.get(u).add(v);

        // Undirected graph
        adjacecyList.get(v).add(u);
    }
}
