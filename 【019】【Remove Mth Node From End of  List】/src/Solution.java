
/**
 * @author hjy
 * @create 2018/03/17
 **/
public class Solution {


	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null || n < 1) {
			return head;
		}

		ListNode fast = head;

		// 要构造长度为 n +1 的窗口
		for (int i = 0; i < n; i++) {
			//fast 指针指向倒数第一节点的时候，就是要删除头结点
			//链表长度小于n
			if (fast == null) {
				return head;
			} else {
				fast = fast.next;
			}
		}

		//当n等于 len时的情况 之前循环没判断是否为空
		if (fast == null) {
			return head.next;
		}

		//走到这步时 n < len
		ListNode pre = head.next;
		while (fast.next != null) {
			pre = pre.next;
			fast = fast.next;
		}

		pre.next = pre.next.next;

		return head;
	}

	public static void main(String[] args) {

		ListNode listNode = new ListNode(0);
		ListNode tail = listNode;
		for (int i = 1; i <= 10; i++) {
			tail.next = new ListNode(i);
			tail = tail.next;
		}

		System.out.println(listNode.toString());
		new Solution().removeNthFromEnd(listNode,6);
		System.out.println(listNode.toString());

	}

}
