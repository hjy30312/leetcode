class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null ||n < 1) {
			return null;
		}
		ListNode fast = head;

		// n + 1 窗口  先走n步
		for (int i = 1 ; i <= n; i++) {
			if (fast == null) {
				return head;
			} else {
				fast = fast.next;
			}
		}

	   // 由于 n = len 再循环内部没有判断直接前进了一个节点，
	   // 临界值 n = len 的时候 则删除头结点 直接return head.next;
	   if (fast == null){
		   return head.next;
	   }

	   ListNode slow = head;

	   while (fast.next != null) {
		   fast = fast.next;
		   slow = slow.next;
	   }

	   slow.next = slow.next.next;
	   return head;
	}


}