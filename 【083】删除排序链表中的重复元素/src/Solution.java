

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = head;
        if (head == null) {
            return head;
        }
        while (head.next  != null) {
            //后面的值和前面的值相等
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return ans;
    }




    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        ListNode listNode = new Solution().deleteDuplicates(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
