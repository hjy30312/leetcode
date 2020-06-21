/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            // 反指
            cur.next = pre;
            // 下次循环 pre节点即为当前节点
            pre = cur;
            // 下次循环 cur为cur.ext节点
            cur = tmp;
        }
        return pre;
    }
}
