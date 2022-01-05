package com.achui.leetcode.easy;

/**
 * No.35 搜索插入的位置 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class SearchInsert_35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return high + 1;
    }
//    public int searchInsert(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        return binarySearch(nums, target, 0, nums.length - 1);
//    }
//
//    private int binarySearch(int[] nums, int target , int left, int right) {
//        int middle = left + ((right - left) >> 1);
//        System.out.println("middle:" + middle);
//        if(left == right) {
//            return nums[left] > target? left : left + 1;
//        }
//
//        if(nums[middle] < target) {
//            return binarySearch(nums, target, middle + 1, right);
//        } else {
//            return binarySearch(nums, target, left, middle);
//        }
//    }

    public static void main(String[] args) {
        SearchInsert_35 si = new SearchInsert_35();
        int[] nums = {1,3};
        System.out.println("result: " + si.searchInsert(nums, 0));
    }
}
