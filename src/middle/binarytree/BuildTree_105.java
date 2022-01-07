package middle.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 *  No.105 前序+中序遍历序列构建二叉树
 */
public class BuildTree_105 {

    int preIndex;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode helper(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int rootValue = preorder[preIndex];

        int idxPosition = idxMap.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        preIndex ++;

        root.left = helper(inLeft, idxPosition - 1);
        root.right = helper(idxPosition + 1, inRight);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;

        preIndex = 0;
        int idx = 0;
        for (int i : inorder) {
            idxMap.put(i, idx ++);
        }

        return helper(0, inorder.length - 1);
    }
}
