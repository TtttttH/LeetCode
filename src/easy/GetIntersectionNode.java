package com.achui.leetcode.easy;

/**
 * leetcode 面试题02.07 链表相交
 */
public class GetIntersectionNode {
    public ListNode getintersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int countA = 0;
        int countB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            countA ++;
        }

        while (curB != null) {
            curB = curB.next;
            countB ++;
        }

        curA = headA;
        curB = headB;
        if ((countA > countB)) {
            while(countA != countB) {
                curA = curA.next;
                countA --;
            }
        } else {
            while (countA != countB) {
                curB = curB.next;
                countB --;
            }
        }

        while(countA >= 0) {
            if (curA == curB) {
                return curA;
            } else {
                curA = curA.next;
                curB = curB.next;
                countA --;
            }
        }
        return null;
    }
}
