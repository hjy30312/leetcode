import java.util.List;
import java.util.Stack;

public class Solution<T> {

    public ListNode<T> reverse(ListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<T> temp = head.next;
        ListNode<T> newHead = reverse(head.next);
        // 反指
        temp.next = head;
        // 断正指
        head.next = null;
        return  newHead;
    }


    public ListNode<T> reverse2(ListNode<T> head) {
        ListNode<T> pre = null;
        ListNode<T> next = null;
        while (head != null) {
            next =head.next;
            // 反指
            next.next = pre;
            pre = head.next;
            head = next;
        }
        return pre;
    }
}
