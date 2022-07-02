package middle.binarytree;

/**
 * No.1214 查找两棵二叉搜索树之和(Microsoft)
 */
public class No_1214 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        //这种存在重复计算，复杂度很高
//        if (root1 == null || root2 == null) return false;
//        int sum = root1.val + root2.val;
//        if (sum == target) return true;
//        if (sum > target) return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
//        else  return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
        if (root1 == null || root2 == null) return false;
        //这样相当于暴力循环，复杂度O(MN)
        return helper(root2, target - root1.val) || twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2,target);
    }

    private boolean helper(TreeNode root2, int target) {
        if (root2 == null) return false;
        if (root2.val == target) return true;
        if (root2.val < target) return helper(root2.right, target);
        return helper(root2.left, target);
    }
}
