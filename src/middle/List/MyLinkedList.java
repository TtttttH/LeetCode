package com.achui.leetcode.middle.List;

import java.util.LinkedList;

/**
 * No.707 :设计链表
 */
class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0); // pseudo-head, not the real head node
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        while (index < 0) {
            cur = cur.next;
            index --;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode preHead = new ListNode(val);
        preHead.next = head;
        size ++;
    }

    public void addAtTail(int val) {
        ListNode cur = head;
        ListNode newNode = new ListNode(val);
        while (cur.next != null) {
            cur = cur.next;
        }
        size ++;

        cur.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        ListNode cur = head;
        if (index <= 0) {
            ListNode tmp = cur.next;
            cur.next = new ListNode(val);
            cur.next.next = tmp;
            size ++;
        } else if (index <= size){
            while (index > 0) {
                cur = cur.next;
            }
            ListNode tmp = cur.next;
            cur.next = new ListNode((val));
            cur.next.next = tmp;
            size ++;
        } else {
            return ;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            ListNode dynamicNode = head;
            while(index > 0) {
                dynamicNode = dynamicNode.next;
                index --;
            }
            dynamicNode.next = dynamicNode.next.next;
            size --;
        }
    }
}
