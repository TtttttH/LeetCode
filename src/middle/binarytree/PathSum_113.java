package com.achui.leetcode.middle.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * No.113 路径总和II
 */
public class PathSum_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();

    }

    private List<Integer> getPathSum(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return path;
        }

        targetSum = targetSum - root.val;

        path.add(root.val);
    }

}
