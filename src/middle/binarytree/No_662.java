package middle.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.662 二叉树最大宽度(Microsoft)
 */
public class No_662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> idxList = new LinkedList<>();
        queue.offer(root);
        idxList.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                int idx = idxList.remove(0);
                if (node.left != null) {
                    queue.offer(node.left);
                    idxList.add(idx * 2);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    idxList.add(idx * 2 + 1);
                }
            }

            if (idxList.size() > 2) res = Math.max(res, idxList.get(idxList.size() - 1) - idxList.get(0) + 1);
        }

        return res;
    }
}
