public class BinarySearchTree<T extends Comparable<T>> {

  private int nodeCount = 0;
  private Node root = null;


  private class Node {
    T data;
    Node left;
    Node right;

    public Node(Node left, Node right, T element) {
      this.left = left;
      this.right = rigth;
      this.data = element;
    }

    public boolean isEmpty() {
      return nodeCount == 0;
    }

    public int size() {
      return nodeCount;
    }

    public boolean add(T element) {
      if(contains(element)) {
        return false;
      } else {
        root = add(root, element);
        nodeCount++;
        return true;
      }
    }

    private Node add(Node node, T element) {
      if(node == null) {
        node = new Node(null, null, element);
      } else if(node.data.comapareTo(element) > 0) {
        node.left = add(node.left, element);
      } else {
        node.right = add(node.right, element);
      }
      return node;
    }
    
    public Node search(Node node, T element) {
      if(node == null || node.data.compareTo(element) == 0) {
        return node;
      } else if(node.data.compareTo(element) > 0) {
        return search(node.left, element);
      } else {
        return search(node.right, element);
      } 
    }
  }
}
