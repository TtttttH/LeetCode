package middle.binarytree;

import java.util.*;

/**
 * No_863 二叉树中所有距离为K的结点(Microsoft)
 */
public class No_863 {
    Map<TreeNode, TreeNode> parents = new HashMap<>();

    Set<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find(root, null);
        List<Integer> res = new ArrayList<>();
        dfs(target, res, k - 1);
        return res;
    }


    private void find(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parents.put(root, parent);
        find(root.left, root);
        find(root.right, root);
    }

    private void dfs(TreeNode root, List<Integer> list, int distance) {
        if (root != null && !visited.contains(root)) {
            visited.add(root);
            if (distance == 0) list.add(root.val);
            dfs(root.left, list, distance - 1);
            dfs(root.right, list, distance - 1);
            dfs(parents.get(root), list, distance - 1);
        }
    }
}
