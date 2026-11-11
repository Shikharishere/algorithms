package main.java.com.shikhar.algorithms.graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graphs.datastructures.AdjacencyList;

public class BFSAdjacencyList {
    private Queue<Integer> queue;
    private boolean[] visited;
    private AdjacencyList graph;
    private Integer[] prev;

    public BFSAdjacencyList(AdjacencyList graph) {
        queue = new ArrayDeque<>();
        visited = new boolean[graph.size()];
        this.graph = graph;
        prev = new Integer[graph.size()];
    }

    public List<Integer> shortestPath(int start, int end) {
        bfs(start);
        LinkedList<Integer> path = new LinkedList<>();

        for(Integer at = end; at != null; at = prev[at]) {
            path.addFirst(at);
        }

        if(path.isEmpty() || path.getFirst().intValue() != start) {
            return List.of();
        }
        return path;
    }

    public void bfs(int start) {
        queue.add(start);
        visited[start] = true;
        System.out.print("[" + start + " ,");

        while(!queue.isEmpty()) {
            start = queue.remove();
            for(Integer neighbour : graph.getNeighbours(start)) {
                if(!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    prev[neighbour] = start;
                    System.out.print(neighbour + ", ");
                }
            }
        }
        System.out.println(" ]");
    }
    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(8);
        graph.addEdge(0, 1, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(0, 3, false);
        graph.addEdge(1, 4, false);
        graph.addEdge(2, 5, false);
        graph.addEdge(3, 6, false);
        graph.addEdge(4, 6, false);
        graph.addEdge(4, 7, false);
        graph.addEdge(5, 7, false);
        graph.addEdge(6, 7, false);

        // System.out.println(graph.getNeighbours(3));
        BFSAdjacencyList bfs = new BFSAdjacencyList(graph);
        // bfs.bfs(0);
        // System.out.println(bfs.shortestPath(0,7));
        System.out.println(bfs.shortestPath(3,5));
    }
}
