public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	//头结点
		ListNode head = new ListNode(0);
		//尾结点
		ListNode tail = head;

		while (l1 != null && l2 != null) {
			if ((l1.val <= l2.val)) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		//当一个链表取完  直接把另一个链表接上尾结点
		if (l1 != null) {
			tail.next = l1;
		} else {
			tail.next = l2;
		}
		return head.next;
	}
	public static void main(String[] args) {
	    ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		System.out.println(new Solution().mergeTwoLists(l1, l2));
	}
}