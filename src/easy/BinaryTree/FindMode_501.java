package easy.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.501 二叉搜索树中的众数 (实现空间复杂度O(1) 其实很难，注意Morris中序遍历法!)
 */
public class FindMode_501 {

    List<Integer> list = new ArrayList<>();

    int base, count;
    int maxCount = Integer.MIN_VALUE;

    private void update(int x) {
        if (x == base) {
            count ++;
        } else {
            base = x;
            count = 1;
        }

        if (count == maxCount) {
            list.add(x);
        }
        if (count > maxCount) {
            list.clear();
            maxCount = count;
            list.add(x);
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }

            //cur.left != null;
            TreeNode pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }

            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                update(cur.val);
                pre.right = null;
                cur = cur.right;
            }
        }

        int[] results = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            results[i] = list.get(i);
        }
        return results;
    }
//    Map<Integer, Integer> valMap = new HashMap<>();
//
//    private void traversal(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        traversal(root.left);
//        valMap.put(root.val, valMap.getOrDefault(root.val, 0) + 1);
//        traversal(root.right);
//    }
//    public int[] findMode(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//
//        traversal(root);
//        int max = Integer.MIN_VALUE;
//        for (int key : valMap.keySet()) {
//            max = Math.max(max, valMap.get(key));
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int key: valMap.keySet()) {
//            if (valMap.get(key) == max) {
//                list.add(key);
//            }
//        }
//
//        int[] results = new int[list.size()];
//        int idx = 0;
//        for (int i : list) {
//            results[idx ++] = i;
//        }
//
//        return results;
//    }
}
