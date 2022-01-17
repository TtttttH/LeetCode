package middle.List;

/**
 * No.92 反转链表
 */
public class ReverseBetween_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode preLeft = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode pre = null;
        for (int i = 1; i <= right; i ++) {
            if (i == left - 1) {
                preLeft = cur;
            }

            if (i == left) {
                leftNode = cur;
            }

            if (i == right) {
                rightNode = cur;
            }

            cur = cur.next;
        }

        pre = cur;
        cur = leftNode;

        for (int i = left; i <= right; i ++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        if(left > 1){
            preLeft.next = rightNode;
            return head;
        } else {
            return pre;
        }

    }
}
