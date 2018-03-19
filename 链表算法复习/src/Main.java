import java.util.ArrayList;

/**
 * @author hjy
 * @create 2018/03/18
 **/
public class Main {
	/**
	 * 获取单链表的长度
	 * @param head
	 * @return
	 */
	public int getLength(Node head) {

		if (head == null) {
			return 0;
		}

		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	/**
	 * 得到位置的值
	 * @param head
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public int getValueOfIndex(Node head, int index) throws Exception {

		if (index < 0 || index >= getLength(head)) {
			throw new Exception("越界！");
		}

		if (head == null) {
			throw new Exception("当前链表为空！");
		}

		Node ans = head;

		while (ans.next != null && index > 0) {
			ans = ans.next;
			index--;
		}
		return  ans.value;
	}

	/**
	 * 得到值的下标
	 * @param head
	 * @param value
	 * @return
	 */
	public int getNodeIndex(Node head, int value) {

		int index = -1;
		Node ans = head;

		while (ans != null) {
			index++;
			if (ans.value == value) {
				return index;
			}
			ans = ans.next;
		}
		return -1;
	}

	/**
	 * 在已有链表头部插入一个结点
	 * @param head
	 * @param value
	 * @return
	 */
	public Node addAtHead(Node head, int value) {
		Node newHead = new Node(value);
		newHead.next = head;
		return newHead;
	}

	/**
	 * 已有链表的尾部插入结点
	 * @param head
	 * @param value
	 */
	public  void addAtTail(Node head, int value) {
		Node node = new Node(value);
		Node dummyHead = head;

		//找到尾结点
		while (dummyHead.next != null) {
			dummyHead = dummyHead.next;
		}

		dummyHead.next = node;
	}

	/**
	 * 在指定位置添加一个结点
	 * @param head
	 * @param value
	 * @param index
	 * @return
	 */
	public Node insertElement(Node head, int value, int index) throws Exception {


		int len = getLength(head);

		if (index >= len || index < 0) {
			throw new Exception("下标越界");
		}

		if (index == 0) {
			//添加头结点
			return addAtHead(head,value);
		} else if (index == len-1) {
			addAtTail(head, value);
		} else {
			Node pre = head;
			Node cur = head.next;

			while (index > 1) {
				pre = pre.next;
				cur = cur.next;
				index--;
			}

			//要插入的新结点
			Node newNode = new Node(value);
			//循环结束后 pre 保存的是索引的上一个节点 而 cur 保存的是索引值当前的节点
			pre.next = newNode;
			newNode.next = cur;
		}
		return head;
	}

	/**
	 * 得到列表中间节点
	 * @param head
	 * @return
	 */
	public Node getMid(Node head) {
		if (head == null) {
			return null;
		}

		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = fast.next;
		}
		return slow;
	}


	/**
	 * 判断是否为循环链表
	 * @param head
	 * @return
	 */
	public boolean isLoopList(Node head) {
		if (head == null) {
			return false;
		}

		Node slow = head;
		Node fast = head.next;

		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast || fast.next == slow) {
				return true;
			}
			// 快慢
			fast = fast.next.next;
			slow = slow.next;
		}
		//不是循环链表  遇到null
		return false;
	}

	/**
	 * 获得倒数第n个结点
	 * 快慢指针的思想  提供一个滑动窗口
	 * 情况：
	 * 1.输入的链表为空 且N小于1
	 * 2.n大于链表的长度
	 * 3.正常情况： fast先走n-1步   与slow 形成窗口 依次向尾结点走
	 * 当fast.next为空时(说明到达尾结点)时 slow则为倒数第n个结点
	 */
	public Node getLastIndexNode(Node head,int n) {

		// 输入的链表不能为空 且N小于1
		if (n < 1 || head == null) {
			return null;
		}

		Node fast = head;

		//先走n-1步
		for (int i = 1; i < n; i++) {

			if (fast.next != null) {
				fast = fast.next;
			} else {
				//说明 n>len 链表的长度
				return null;
			}
		}

		Node slow = head;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * 和找到倒数第n结点类似 但这是要删除，所以我们找到倒数第n+1个结点
	 * 所以此时的滑动窗口则为 n + 1
	 */
	public Node deleteLastNode(Node head, int n) throws Exception {

		if (head == null ||n < 1) {
			return null;
		}
		Node fast = head;

		// n + 1 窗口  先走n步
		for (int i = 1 ; i <= n; i++) {
			if (fast.next != null) {
				fast = fast.next;
			} else {
				throw new Exception("数组越界");
			}
		}

		Node slow = head;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return head;
	}


	/**
	 * 题目：给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数。
	 * 如给出链表为 1->2->3->4->5->NULL and k = 2,
	 * return 4->5->1->2->3->NULL.
	 * 找到 k 位置结点 将其变成尾结点，然后原来链表的尾结点指向原来的头结点
	 */
	public Node rotateList(Node head, int n) {
		int position = 1;

		Node fast = head;

		//快指针先走n个位置
		while (position < n && fast.next != null) {
			fast = fast.next;
			position++;
		}

		//循环结束后如果 position < n 表示 n比整个链表还要长 旋转后还是原链表
		//如果 fast.next = null 表示 n 正好等于原链表的长度此时也不需要旋转
		if (fast.next == null || position < n) {
			return head;
		}

		//倒数第 n + 1个结点
		Node pre = fast;
		//旋转后的头结点
		Node newHead = fast.next;

		//走到尾结点
		while (fast.next != null) {
			fast = fast.next;
		}
		//将原链表的最后一个结点指向原来的头结点
		//形成环
		fast.next = head;

		//断开环：将旋转的结点的上一个结点变成尾结点
		pre.next = null;

		return newHead;
	}


}
