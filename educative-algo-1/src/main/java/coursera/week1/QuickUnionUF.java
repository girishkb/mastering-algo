package coursera.week1;

public class QuickUnionUF {

    private int[] id;

    //Holds size of connected components.
    private int[] sz;

    // # of connected components.
    private int count;


    public QuickUnionUF(int N){
        this.id  = new int[N];
        this.sz = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] =1;
        }

    }

    private int root(int i){
        while ( i != id[i]){
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j  = root(q);
        id[i] = id[j];
    }

    public void unionWeighted(int p, int q){
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if(sz[i]<sz[j]) {
            id[i] = j;
            sz[i]+= sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public int getCount(){
        return count;
    }

}
