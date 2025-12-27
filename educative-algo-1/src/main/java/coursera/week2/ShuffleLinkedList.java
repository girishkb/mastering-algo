package coursera.week2;

import jdk.dynalink.beans.StaticClass;

import java.util.Random;

public class ShuffleLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int v) {
            this.val = v;
        }
    }

    static Random random  = new Random();
    public static Node shuffle(Node head) {
        if (head == null || head.next == null) return  head;

        Node middle = getMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node leftShuffled = shuffle(head.next);
        Node rightShuffled = shuffle(right);
        return randomMerge(leftShuffled,rightShuffled);
    }

    public static Node randomMerge(Node left, Node right){
        if (left == null) return  right;
        if (right == null) return  left;
        if (random.nextBoolean()){
            left.next = randomMerge(left.next,right);
            return left;
        }else{
            right.next = randomMerge(left,right.next);
            return right;
        }
    }

    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head.next.next;
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return  slow;
    }
}
