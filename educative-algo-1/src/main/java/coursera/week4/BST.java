package coursera.week4;

import org.w3c.dom.Node;

public class BST<Key extends  Comparable<Key>, Value> {

    private Node root;

    public void put(Key key, Value value){
        root = put(root,key,value);
    }

    private  Node put(Node node,Key key, Value value){
        if (node == null) {
            return  new Node(key,value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left,key,value);
        } else if (cmp>0) {
            node.right = put(node.right,key,value);
        }else{
            node.value = value;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Value geKey(Key key) {
        Node x = root;
        while (x !=null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            }
            else return x.value;
        }
        return null;
    }

    public  Key min(){
        if (root == null) return null;
        Node x = root;
        while (x.left !=null) {
            x = x.left;
        }
        return x.key;
    }

    public Key max(){
        if (root == null) return null;
        Node x = root;
        while (x.right != null) {
            x = x.right;
        }
        return  x.key;
    }

    public int size(){
        return size(root);
    }
    private int size(Node x){
        if (x == null) return 0;
        return  x.count;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    public Node deleteMin(Node x) {
        if (x.left == null) return  x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private  Node right;
        private int count;

        public Node(Key key,  Value v){
            this.key = key;
            this.value = v;
            this.count = 1;
        }
    }
}
