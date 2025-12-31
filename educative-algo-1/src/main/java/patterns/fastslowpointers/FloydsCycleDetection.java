package patterns.fastslowpointers;

public class FloydsCycleDetection {
    ListNode head;

    public boolean detectCycle(ListNode head){
        return getMeetingPoint(head) != null;
    }

    public  int cycleLength(ListNode head){

        ListNode meetingPoint = getMeetingPoint(head);

        if(meetingPoint == null) return 0;
        ListNode curr = meetingPoint;
        int cycleLength = 0;

        do {
            curr = curr.next;
            cycleLength++;
        } while (curr != meetingPoint);
        return  cycleLength;
    }

    public  ListNode findStartNode(ListNode head) {
       ListNode meetingPoint =  getMeetingPoint(head);

       if (meetingPoint == null) {
           return  null;
       }
        ListNode curr = head;
        while ( curr != meetingPoint) {
            curr = curr.next;
            meetingPoint = meetingPoint.next;
        }
        return curr;
    }

    //Shared helper
    public ListNode getMeetingPoint(ListNode head) {
        if (head == null || head.next == null)  {
            return  null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return  slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        ListNode A = new ListNode(2);
        ListNode B = new ListNode(8);
        ListNode C = new ListNode(1);
        ListNode D = new ListNode(5);
        ListNode E = new ListNode(3);
        ListNode F = new ListNode(6);
        ListNode G = new ListNode(9);
        ListNode H = new ListNode(7);




        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        F.next = G;
        G.next = H;
        H.next = B;

        FloydsCycleDetection fc = new FloydsCycleDetection();
        fc.head = A;
        System.out.println("hasCycle :: " + fc.detectCycle(A));

        System.out.println("Cycle Length ::" + fc.cycleLength(A));

        System.out.println("Cycle starting node :: " + fc.findStartNode(A));

    }

}


