package com.achui.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums,和一个目标值target，返回两个数和为target的数组下标
 * O(n)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (resultMap.containsKey(tar)) {
                return new int[]{resultMap.get(tar), i};
            }
            resultMap.put(nums[i], i);
        }
        return null;
    }
}
