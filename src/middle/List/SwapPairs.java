package com.achui.leetcode.middle.List;

/**
 * No.24 两两交换链表中的结点
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
//           temp.next = node2; 这里可以和下面的位置替换不影响
            //这里重点注意node1和node2的next替换顺序不能对换！不然会出现循环节点node1！
            node1.next = node2.next;
            node2.next = node1;
            temp.next = node2;
            temp = node1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        SwapPairs sp = new SwapPairs();
        ListNode cur = a.next;
        sp.swapPairs(a);

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
