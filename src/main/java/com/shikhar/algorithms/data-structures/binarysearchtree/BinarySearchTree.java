import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

  private int nodeCount = 0;
  private Node root = null;


  private class Node {
    T data;
    Node left;
    Node right;

    public Node(Node left, Node right, T element) {
      this.left = left;
      this.right = right;
      this.data = element;
    }
  }

    public boolean isEmpty() {
      return size() == 0;
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

    public boolean remove(T element) {
        if(contains(element)) {
            nodeCount--;
            root = remove(this.root, element);
            return true;
        } else {
            return false;
        }
    }

    private Node remove(Node node, T element) {
        if(node == null) return null; 

        int cmp = element.compareTo(node.data);

        if(cmp < 0) {
            node.left = remove(node.left, element);
        } else if (cmp > 0) {
            node.right = remove(node.rigth, element);
        } else {
            if(node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node min = findMin(node.right);
                node.data = min.data;

                node.right = remove(node.right, min.data);
            }
        }

        return node;
    }

    private Node findMin(Node node) {
        while(node.left != null) node = node.left;
        return node;
    }

    private Node findMax(Node node) {
        while(node.right != null) node = node.right;
        return node;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
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

    private boolean contains(T element) {
        Node node = search(root, element);
        if(node == null) {
            return false;
        }
        return true;
    }

    public void traverse(TraversalType type) {
        switch (type) {
            case PRE_ORDER:
                preorder(root); 
                break;
            case IN_ORDER: 
                inorder(root);
                break;
            case POST_ORDER:
                postorder(root);
                break;
            case LEVEL_ORDER:
                levelorder(root);
                break;
             default:
                preorder(root);
                 break;
         } 
    }

    private void preorder(Node node) {
        if(root == null) {
            return;
        }
        System.out.print(node.data.toString() + ", ");
        preorder(node.left);
        preorder(node.right);
    }

    private void inorder(Node node) {
        if(root == null) {
            return;
        }
        preorder(node.left);
        System.out.print(node.data.toString() + ", ");
        preorder(node.right);
    }

    private void postorder(Node node) {
        if(root == null) {
            return;
        }
        preorder(node.left);
        preorder(node.right);
        System.out.print(node.data.toString() + ", ");
    }

    private void levelorder(Node node) {
        if(node == null) {
            return;
        }

        Queue<T> q = new LinkedList<T>();
        q.add(node);

        while(!q.isEmpty()) {
            Node parent = q.remove();
            System.out.print(parent.data.toString() + ", ");
            if(parent.left != null) {
                q.add(parent.left);
            } 
            if(parent.right != null) {
                q.add(parent.right);
            }
        }
    }
  }
}
