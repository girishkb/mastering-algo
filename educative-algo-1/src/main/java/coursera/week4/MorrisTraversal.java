package coursera.week4;


/*
* In-order traversal of a Binary Tree with O(1) extra space – Morris Traversal
*/
public class MorrisTraversal {

    public void inOrder(TreeNode root){

        TreeNode current = root;
        while (current != null) {


            if (current.left == null) {
                System.out.println(current.value + "-->");
                current = current.right;
            } else{
                TreeNode predecessor = current.left;
                while (predecessor != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }else{
                    predecessor.right = null;
                    System.out.println(predecessor.value + "-->");
                    current = current.right;
                }
            }
        }
    }

    private class TreeNode<Key,Value>{
        private TreeNode root;
        Key key;
        Value value;
        private TreeNode left;
        private TreeNode right;

        TreeNode(Key key, Value value){
            this.key  = key;
            this.value = value;
        }
    }
}
