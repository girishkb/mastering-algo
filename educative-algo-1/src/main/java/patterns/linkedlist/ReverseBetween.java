package patterns.linkedlist;

public class ReverseBetween<T> {

    public ListNode<T> reverseBetween(ListNode<T> head, int left, int right) {

        if (head == null || left == right || right < left  || left < 1) {
            return  head;
        }

        ListNode<T> dummy = new ListNode<>( null,head);

        // 1) rach node at position "left"
        // leftPrev is node before the left position.

        ListNode<T> leftPrev = dummy;

        for (int i = 0; i < left-1 ; i++) {
            leftPrev = leftPrev.next;
            if (leftPrev == null )return head; // Invalid left.
        }


        // 2) reverse from left to right
        ListNode<T> curr =  leftPrev.next;
        ListNode<T> reverseHead = null;
        ListNode<T> reverseTail = curr;
        for (int i = 0; i < right - left + 1 ; i++) {
            ListNode<T> tmpNext = curr.next;
            curr.next  = reverseHead;
            reverseHead = curr;
            curr = tmpNext;
        }

         // 3) update pointers
        leftPrev.next = reverseHead;
        reverseTail.next = curr;
        return  dummy.next;
    }

    public static void main(String[] args) {
        ReverseBetween<Integer> rs = new ReverseBetween<>();

        ListNode<Integer> l1  = new ListNode<>(5);
        ListNode<Integer> l2  = new ListNode<>(4,l1);
        ListNode<Integer> l3  = new ListNode<>(3,l2);
        ListNode<Integer> l4  = new ListNode<>(2,l3);
        ListNode<Integer> l5  = new ListNode<>(1,l4);

        System.out.println("\n Input ::" + l5.toString() + " Output ::" + rs.reverseBetween(l5,2,4));
    }

}
