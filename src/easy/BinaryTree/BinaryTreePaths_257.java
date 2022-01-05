package easy.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.257 二叉树的所有路径
 */
public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode node, List<Integer> paths, List<String> res) {
        paths.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <  paths.size() - 1; i ++) {
                sb.append(paths.get(i));
                sb.append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (node.left != null) {
            traversal(node.left, paths, res);
            paths.remove(paths.size() - 1);
        }

        if (node.right != null) {
            traversal(node.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }
}
