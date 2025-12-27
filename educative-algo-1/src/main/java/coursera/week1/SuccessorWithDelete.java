package coursera.week1;


public class SuccessorWithDelete {
    private int n;
    private UFWithMaxParent uf;

    public SuccessorWithDelete(int n){
        n =n;
        uf = new UFWithMaxParent(n);
    }

    public void remove(int x){
        uf.union(x,x+1);
    }

    public int successor(int x){
        int root = uf.root(x);
        int ans = uf.find(root); // largest element of the root.
        return  ans;
    }



}
