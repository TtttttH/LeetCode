package easy;

/**
 * No.234 回文链表
 * Microsoft
 */
public class No_234 {
    public boolean isPalindrome(ListNode head) {
        //思路快慢指针 + 翻转后半链表，没想出来第一次
        ListNode fast = head;
        ListNode slow = fast;
        ListNode pre = null;
        while (fast != null) {
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
        }

        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }

        return true;
    }
}
