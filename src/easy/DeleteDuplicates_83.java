package easy;

/**
 * No.83 删除排序链表中的重复元素
 */
public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = head;
        while (cur.next != null) {
            if (cur.val != cur.next.val) {
                pre.next = cur.next;
                pre = pre.next;
            }

            cur = cur.next;
        }

        pre.next = null;

        return head;
    }
}
