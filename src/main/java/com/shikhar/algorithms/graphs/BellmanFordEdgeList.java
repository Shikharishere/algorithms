package main.java.com.shikhar.algorithms.graphs;

import main.java.com.shikhar.algorithms.graphs.datastructures.EdgeList;

public class BellmanFordEdgeList {
    private int[] dist;

    public double[] bellmanFord(EdgeList graph, int V, int startNode) {
        double[] dist = new double[V];
        
        // 1. Setup
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[startNode] = 0.0;
        
        // 2. Core Algorithm (Relax all edges V - 1 times)
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : graph.getGraph()) {
                if (dist[edge.from] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }
        
        // 3. Negative Cycle Detection (Run V - 1 times again)
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : graph.getGraph()) {
                if (dist[edge.from] + edge.cost < dist[edge.to]) {
                    // If we can STILL relax an edge, it's caught in a negative cycle.
                    dist[edge.to] = Double.NEGATIVE_INFINITY;
                }
            }
        }
        
        return dist;
    }    
}
