package SwordToOffer.middle;

/**
 * No.33 二叉搜索树的后续遍历序列 (Microsoft)
 */
public class Offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) return false;
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int start, int end) {
        if (start == end) return true;
        int rootVal = postorder[end];
        int i = start;
        while (i < end) {
            if (postorder[i] > rootVal) {
                int j = i;
                while (j < end) {
                    if (postorder[j] < rootVal) return false;
                    j ++;
                }
                break;
            } else i ++;
        }

        return helper(postorder, start, i - 1) && helper(postorder, i, end - 1);
    }
}
