package main.java.com.shikhar.algorithms.graphs.datastructures;

public class EdgeListOther {
    private int edgeCount;
    private List<List<Edge>> graph;

    // from --edge--cost--> to
    private static class Edge {
        private int to;
        private double cost;

        public Edge(int from, int to, double cost) {
            this.to = to;
            this.cost = cost;
        }
    } 

    public EdgeList(int n) {
        this.graph = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int cost) {
        edgeCount++;
        graph.get(from).add(new Edge(to, cost));
    }

    public int size() {
        return graph.size();
    }

    public int edgeCount() {
        return edgeCount;
    }

    public List<Edge> getGraph() {
        return this.graph;
    }
}
