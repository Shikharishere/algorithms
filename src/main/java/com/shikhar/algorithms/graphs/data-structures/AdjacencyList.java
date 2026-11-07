import java.util.List;
import java.util.ArrayList;

public class AdjacencyList {
  
  private List<List<Integer>> adjList;
  private int verticeCount;

  public AdjacencyList(int vertices) {
    this.verticeCount = vertices;
    this.adjList = new ArrayList<>(verticeCount);

    for(int i = 0; i < verticeCount; i++) {
      adjList.add(new ArrayList<>());
    }
  }  

  public void addEdge(int x, int y, boolean directed) {
    if(x < 0 || x > verticeCount || y < 0 || y > verticeCount) {
      throw new IllegalArgumentException("Invalid vertices specified\n");
    }
    
    adjList.get(x).add(y);
    if(directed) {
      adjList.get(y).add(x);
    }
  }

  public boolean hasEdge(int x, int y) {
    if(x < 0 || x > verticeCount || y < 0 || y > verticeCount) {
      throw new IllegalArgumentException("Invalid vertices specified\n");
    }

    for(int i : adjList.get(x)) {
      if(i == y) {
        return true;
      }
    }

    return false;
  }

  public List<Integer> getNeighbours(int x) {
    if(x < 0 || x > verticeCount) {
      throw new IllegalArgumentException("Invalid vertex specified\n");
    }

    return adjList.get(x);
  } 

  public void printNeighbours(int x) {
    System.out.print("Vertices of " + x + " are: ");
    System.out.println(getNeighbours(x).toString());
  }

  public static void main(String[] args) {
   AdjacencyList graph = new AdjacencyList(10);

    graph.addEdge(1, 0, true);
    graph.addEdge(2, 0, true);
    graph.addEdge(3, 0, true);

    graph.printNeighbours(0);
    graph.printNeighbours(3);
    graph.printNeighbours(1);

    System.out.println(graph.hasEdge(1, 9)); 
  }
}
