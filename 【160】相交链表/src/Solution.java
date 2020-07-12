
/**
 * 双指针法
 * AB相交： A非公共 + 2倍AB公共 + B非公共 == B非公共 + 2倍AB公共 + A非公共
 * AB不相交： A非公共 + B非公共 == B非公共 + A非公共 最后都为null 相等退出循环
 * @author hjy
 * @date 2020/7/12 14:04
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
