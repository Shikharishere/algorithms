package graphs;

import graphs.datastructures.AdjacencyList;

public class DFSAdjacencyList {
    public static void dfs(int x, AdjacencyList graph) {
        dfs(x, graph, new boolean[graph.size() + 1]);
    }

    private static void dfs(int x, AdjacencyList graph, boolean[] visited) {
        if(visited[x]) {
            return;
        }
        visited[x] = true;
        System.out.print(x + " -> ");

        for(Integer neighbour : graph.getNeighbours(x)) {
            dfs(neighbour, graph, visited);
        }
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(10);
        graph.addEdge(0, 9, false);
        graph.addEdge(0, 1, false);
        graph.addEdge(9, 8, false);
        graph.addEdge(1, 8, false);
        graph.addEdge(8, 7, false);
        graph.addEdge(7, 10, false);
        graph.addEdge(7, 2, false);
        graph.addEdge(7, 6, false);
        graph.addEdge(7, 3, false);
        graph.addEdge(10, 2, false);

        dfs(0, graph);
    } 
}
