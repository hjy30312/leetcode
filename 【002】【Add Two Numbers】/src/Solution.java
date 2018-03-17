

/**
 * @author: hjy
 * @description:有两个单链表，代表两个非负数，每一个节点代表一个数位，
数字是反向存储的，即第一个结点表示最低位，最后一个结点表示最高位。
求两个数的相加和，并且以链表形式返回。
 */





public class Solution {



	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode p1 = l1;
		ListNode p2 = l2;
		//头结点
		ListNode head = new ListNode(0);
		ListNode tail = head;
		tail.next = l1;

		//初始化进位
		int carry = 0;
		int sum;
		while (p1 != null && p2 != null) {
			sum = p1.val + p2.val + carry;
			//本位的结果
			p1.val = sum % 10;
			//进位
			carry = sum / 10;

			tail.next = p1;
			//指向最后一个相加的结点
			tail = p1;
			p1 = p1.next;
			p2 = p2.next;
		}

		if (p1 == null) {
			tail.next = p2;
		} else {
			tail.next = p1;
		}

		//最后一次相加的进位
		if (carry == 1) {
			// 开始时r.next是第一次要相加的结点
			while (tail.next != null) {
				sum = tail.next.val + carry;
				tail.next.val = sum % 10;
				carry = sum / 10;
				tail = tail.next;
			}

			// 都加完了还有进位，就要创建一个新的结点
			if (carry == 1) {
				tail.next = new ListNode(1);
			}
		}
		return head.next;
	}

	public static void main(String[] args) {
	    ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		System.out.println(new Solution().addTwoNumbers(l1, l2).toString());

	}
}
