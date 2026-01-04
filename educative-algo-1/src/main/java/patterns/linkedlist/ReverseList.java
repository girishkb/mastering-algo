package patterns.linkedlist;



/*
* Given the head of a singly linked list, reverse the list, and return the reversed list.
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

 *
* */
public class ReverseList<T> {
    ListNode<T> head;;

    public  ListNode<T> reverse(ListNode<T> head) {
        if ( head == null || head.next == null) return  head;

        ListNode<T> prev = null;
        ListNode<T> curr = head ;
        ListNode<T> next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseList<Integer> rs = new ReverseList<>();

        ListNode<Integer> l1  = new ListNode<>(9);
        ListNode<Integer> l2  = new ListNode<>(7,l1);
        ListNode<Integer> l3  = new ListNode<>(5,l2);
        ListNode<Integer> l4  = new ListNode<>(3,l3);
        ListNode<Integer> l5  = new ListNode<>(1,l4);


        System.out.println("Actual List ::" + l5.toString() + "\n Reversed List :: "  + rs.reverse(l5).toString());

    }
}
