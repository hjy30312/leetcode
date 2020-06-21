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


    public ListNode reverse2(ListNode head) {
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
