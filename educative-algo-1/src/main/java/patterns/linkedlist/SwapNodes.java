package patterns.linkedlist;

/*

24. Swap Nodes in Pairs
*Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)


Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]


*
* */
public class SwapNodes<T>{

    public ListNode<T> swapPairs(ListNode<T> head) {

        if ( head == null || head.next == null) return  head;

        ListNode<T> dummy = new ListNode<>(null,head);
        ListNode<T> prev = dummy;
        ListNode<T> curr = head;

        while (curr != null && curr.next != null) {
            // save pointers
            ListNode<T> nextPair = curr.next.next;
            ListNode<T> second = curr.next;

            // reverse this pair
            second.next = curr;
            curr.next = nextPair;
            prev.next = second;

            // update pointers;
            prev = curr;
            curr = nextPair;

        }
        return  dummy.next;
    }

    public static void main(String[] args) {
        SwapNodes<Integer> rs = new SwapNodes<>();

        ListNode<Integer> l1  = new ListNode<>(5);
        ListNode<Integer> l2  = new ListNode<>(4,l1);
        ListNode<Integer> l3  = new ListNode<>(3,l2);
        ListNode<Integer> l4  = new ListNode<>(2,l3);
        ListNode<Integer> l5  = new ListNode<>(1,l4);

        System.out.println("\n Input ::" + l5.toString() + " Output ::" + rs.swapPairs(l5));
    }
}
