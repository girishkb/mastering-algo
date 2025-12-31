package patterns.fastslowpointers;

public class ListNode {
    int data;
    ListNode next;

    ListNode(int val){
        this.data = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}
