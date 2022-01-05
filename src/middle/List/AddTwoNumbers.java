package com.achui.leetcode.middle.List;

/**
 * No.2
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode move = root;
        int flg = 0;
        int l1Val = 0;
        int l2Val = 0;
        while(null != l1 || null != l2 || flg != 0) {
             l1Val = null == l1? 0 : l1.val;
             l2Val = null == l2? 0 : l2.val;
             int sumVal = l1Val + l2Val + flg;
             move.next = new ListNode(sumVal % 10);
             move = move.next;
             flg = sumVal / 10;
             if(null != l1) l1 = l1.next;
             if(null != l2) l2 = l2.next;
        }
        return root.next;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println("result:" + new AddTwoNumbers().addTwoNumbers(l1, l2).val);
    }
}




