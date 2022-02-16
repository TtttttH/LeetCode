package hard.List;

/**
 * No.23 合并K个升序链表  分治合并法 O(kn * logk)
 */
public class No_23_Divide {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return headA == null ? headB : headA;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                pre.next = curA;
                curA = curA.next;
            } else {
                pre.next = curB;
                curB = curB.next;
            }
            pre = pre.next;
        }

        if (curA == null) {
            pre.next = curB;
        } else {
            pre.next = curA;
        }
        return dummy.next;
    }
}
