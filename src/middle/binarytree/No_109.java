package middle.binarytree;

/**
 * No.109 有序链表转换二叉搜索树
 */
public class No_109 {
    public TreeNode sortedListToBST(ListNode head) {
        //思路：快慢指针确定链表中点，递归建立左右子树
        if (head == null) return null;
        else if(head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        while (q != null && q.next != null) {
            pre = pre.next;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null; //剪断
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);

        return root;
    }

}
