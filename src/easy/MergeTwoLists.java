package easy;

/**
 * No.21 合并两个有序链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode move = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                move.next = l1;
                l1 = l1.next;
            } else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }
        if(l1 != null) {
            move.next = l1;
        } else if(l2 != null) {
            move.next = l2;
        }

        return head;
    }
}
