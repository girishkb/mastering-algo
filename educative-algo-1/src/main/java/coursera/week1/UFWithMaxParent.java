package coursera.week1;

public class UFWithMaxParent {
    private int [] parent;
    private int [] largest;
    private int [] size;

    public UFWithMaxParent(int N){
        parent = new int[N];
        largest = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            largest[i] = i ;
            size[i] = i;
        }
    }

    public int root(int p) {
        if( parent[p] == p ) return  p;
        parent[p] = root(parent[p]);
        return  parent[p];
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);

        if(rootP == rootQ) return;

        if(size[rootP] < size[rootQ]) {
          parent[rootP] = rootQ;
          size[rootQ] += size[rootP];
          largest[rootQ] = Math.max(largest[rootP],largest[rootQ]);
        }else{
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            largest[rootP] = Math.max(largest[rootP],largest[rootQ]);
        }
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // Returns the largest element in the connected components.
    public int find(int i){
        int rootI  = root(i);
        return largest[rootI];
    }
}
