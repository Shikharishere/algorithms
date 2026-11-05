public class UnionFind {
  private int size; 
  private int[] sz;
  private int[] id;
  private int numComponents;

  public UnionFind(int size) {

    if(size <= 0) {
      throw new IllegalArgumentException("Size <= 0 is not allowed");
    }

    this.size = size;
    sz = new int[size];
    id = new int[size];

    for(int i = 0; i < size; i++) {
      id[i] = i;
      sz[i] = 1;
    }

  }

  pubic int find(int p) {
    
    int root = p;

    while(root != id[root]) {
      root = id[root];
    }

    while(p != root) {
      int next = id[p];
      id[p] = root;
      p = next;
    }

    return root;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public void union(int p, int q) {

    int rootp = find(p);
    int rootq = find(q);
    
    if(rootp == rootq) {
      return;
    }

    if(sz[rootp] < sz[rootq]) {
      sz[rootq] += sz[rootp];
      id[rootp] = rootq;
    } else {
      sz[rootp] += sz[rootq];
      id[rootq] = rootp;
    }

    numComponents--;

  }

  public int componentSize(int p) {
    return sz[find(p)];
  }

  public int size() {
    return size;
  }

  public int components() {
    return numComponents;
  }

}
