package easy;

/**
 * No.160 相交链表
 */
public class No_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {  // 两边最后相等时一定都走了sizeA + sizeB 的距离，如果无公共节点则null == null 退出循环
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;
        }

        return pA;
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        int lenA = 0, lenB = 0;
//        ListNode curA = headA;
//        ListNode curB = headB;
//        while (curA.next != null) {
//            lenA ++;
//            curA = curA.next;
//        }
//
//        while (curB.next != null) {
//            lenB ++;
//            curB = curB.next;
//        }
//
//        if (curA != curB) {
//            return null;
//        }
//
//        curA = headA;
//        curB = headB;
//        while (lenA != lenB) {
//            if (lenA > lenB) {
//                curA = curA.next;
//                lenA --;
//            } else {
//                curB = curB.next;
//                lenB --;
//            }
//        }
//
//        while (curA != curB) {
//            curA = curA.next;
//            curB = curB.next;
//        }
//
//        return curA;
    }
}
