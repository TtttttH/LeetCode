package middle.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * No.106 从中序与后序遍历序列构造二叉树
 */
public class BuildTree_106 {

    int postIndex;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode helper(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int rootValue = postorder[postIndex];

        TreeNode root = new TreeNode(rootValue);
        int idxPosition = idxMap.get(rootValue);
        postIndex --;

        //这里一定要先建右子树!
        root.right = helper(idxPosition + 1, inRight);
        root.left = helper(inLeft, idxPosition - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;

        postIndex = postorder.length - 1;

        int idx = 0;
        for (int i : inorder) {
            idxMap.put(i, idx ++);
        }
        return helper(0, inorder.length - 1);
    }

    /** 代码随想录 105， 106通用解法
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        int rootValue = postorder[postorder.length - 1];

        TreeNode root = new TreeNode(rootValue);

        if (postorder.length == 1) {
            return root;
        }

        int delimiterIndex;

        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex ++) {
            if (inorder[delimiterIndex] == rootValue) break;
        }

        int[] leftInorder = new int[delimiterIndex];
        int[] rightInorder = new int[inorder.length - delimiterIndex - 1];

        System.arraycopy(inorder, 0, leftInorder, 0, leftInorder.length);
        System.arraycopy(inorder, delimiterIndex + 1, rightInorder, 0, rightInorder.length);

        int[] leftPostorder = new int[delimiterIndex];
        int[] rightPostorder = new int[rightInorder.length];

        System.arraycopy(postorder, 0, leftPostorder,0, leftPostorder.length);
        System.arraycopy(postorder, leftPostorder.length, rightPostorder, 0, rightPostorder.length);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
     **/
}
