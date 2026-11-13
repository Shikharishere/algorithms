package main.java.com.shikhar.algorithms.graphs.datastructures;

import java.util.ArrayList;
import java.util.List;

/*
    Edge List representation of graph with each edge object containing 
    from, to and cost data.
*/

public class EdgeList {
    private int edgeCount;
    private int n;
    private List<Edge> graph;

    // from --edge--cost--> to
    private static class Edge {
        private int from;
        private int to;
        private double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    } 

    public EdgeList(int n) {
        this.edgeCount = 0;
        this.n = n;
        this.graph = new ArrayList<>();
    }

    public void addEdge(int from, int to, int cost) {
        if(graph.size() == edgeCount) {
            throw new RuntimeException("graph is full ^_^ ");
        }
        edgeCount++;
        graph.add(new Edge(from, to, cost));
    }

    public int size() {
        return n;
    }

    public int edgeCount() {
        return edgeCount;
    }


    public List<Edge> getGraph() {
        return this.graph;
    }

}
