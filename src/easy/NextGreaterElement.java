package com.achui.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * No.496 思路：单调栈先处理nums2的数据关系，找到每个数的最大值,存入map再对1做映射
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < nums2.length; i ++) {
//            int j = i + 1;
//            map.put(nums2[i], -1);
//            while (j < nums2.length && nums2[j] < nums2[i]) {
//                j ++;
//            }
//            if (j < nums2.length) {
//                map.put(nums2[i], nums2[j]);
//            }
//        }

        for (int i = 0; i < nums1.length; i ++) {
            map.put(nums1[i], -1);
        }
        Stack<Integer> stack =  new Stack<>();
        for (int i = 0; i < nums2.length; i ++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                map.put(nums2[stack.peek()], nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1,3,4,2};
        System.out.printf(nge.nextGreaterElement(nums1, nums2).toString());
    }

}
