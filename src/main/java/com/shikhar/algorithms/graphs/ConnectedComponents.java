package graphs;

import graphs.datastructures.AdjacencyList;
import java.util.Arrays;

public class ConnectedComponents {
    private int n;
    private AdjacencyList graph;
    private int count;
    private int[] components;
    private boolean[] visited;

    public ConnectedComponents(AdjacencyList graph) {
        this.graph = graph;
        n = graph.size();
        count = 0;
        components = new int[n + 1];
        visited = new boolean[n + 1];
    }

    public void findComponents() {
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
    }

    public void dfs(int at) {
        visited[at] = true;

        components[at] = count;
        for(Integer neighbour: graph.getNeighbours(at)) {
            if(!visited[neighbour]) {
                dfs(neighbour);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(11);
        graph.addEdge(0, 1, false);
        graph.addEdge(1, 7, false);
        graph.addEdge(7, 0, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 5, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(3, 6, false);
        graph.addEdge(6, 9, false);

        ConnectedComponents cc = new ConnectedComponents(graph);

        cc.findComponents();

        System.out.println("Number of components: " + cc.count + " List of components: " + Arrays.toString(cc.components));
    } 
}
