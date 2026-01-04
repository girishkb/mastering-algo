package patterns.linkedlist;

public class ListNode<T> {
    T data;
    ListNode<T> next;

    ListNode( T data) {
        this.data = data;
    }

    ListNode( T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> current = this;

        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }

        sb.append("null");
        return sb.toString();

    }
}
