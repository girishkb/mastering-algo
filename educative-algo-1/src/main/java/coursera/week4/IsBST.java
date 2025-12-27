package coursera.week4;

public class IsBST {

    Node root ;

    public boolean isBST(Node root){
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public  boolean isBST(Node x,Integer min, Integer max){
        if (x ==null) return  true;
        if (x.value <= min  || x.value > max) return  false;
        return isBST(x.left,min,x.value) && isBST(x.right,x.value,max);
    }

    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
}
