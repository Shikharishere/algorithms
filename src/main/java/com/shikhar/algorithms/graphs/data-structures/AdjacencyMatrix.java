import java.util.List;
import java.util.ArrayList;

public class AdjacencyMatrix {
  private boolean[][] matrix;
  private int verticesCount;

  public AdjacencyMatrix(int vertices) {
    matrix = new boolean[vertices][vertices];
    verticesCount = vertices;
  }

  public void addEdge(int x, int y, boolean directed) {
    if(x < 0 || y < 0 || x > verticesCount || y > verticesCount) {
      throw new IllegalArgumentException("Invalid vertices specified\n");
    }

    matrix[x][y] = true;
    if(directed) {
      matrix[y][x] = true;
    }
  }

  public boolean hasEdge(int x, int y) {
    if(x < 0 || y < 0 || x > verticesCount || y > verticesCount) {
      throw new IllegalArgumentException("Invalid vertices specified\n");
    }

    return matrix[x][y];
  }

  public List<Integer> getNeighbours(int x) {
    if(x < 0 || x > verticesCount) {
      throw new IllegalArgumentException("Invalid vertex specified\n");
    }

    List<Integer> neighbours = new ArrayList<>();
    
    for(int i = 0; i < verticesCount; i++) {
      if(matrix[x][i]) {
        neighbours.add(i);
      }
    }
    
    return neighbours;
  }

  public void printNeighbours(int x) {
    if(x < 0 || x > verticesCount) {
      throw new IllegalArgumentException("Invalid vertex specified\n");
    }

    System.out.print("Vertex " + x + " is connected to: ");
     
    System.out.println(getNeighbours(x).toString());
  }

  public static void main(String[] args) {
    AdjacencyMatrix graph = new AdjacencyMatrix(10);

    graph.addEdge(1, 0, true);
    graph.addEdge(2, 0, true);
    graph.addEdge(3, 0, true);

    graph.printNeighbours(0);
    graph.printNeighbours(3);
    graph.printNeighbours(1);

    System.out.println(graph.hasEdge(1, 9));
  }
}
