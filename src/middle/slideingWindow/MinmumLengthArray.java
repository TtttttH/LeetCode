package middle.slideingWindow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.209 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * #
 */
public class MinmumLengthArray {
    public int minLengthArray(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right ++) {
            sum = sum + nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum = sum - nums[left ++];
            }
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1,4,4};
//        int[] nums = {1,1,1,1,1,1,1,1};

        int target = 7;
//        int target = 4;
//        int target = 11;
        MinmumLengthArray mla = new MinmumLengthArray();
        int res = mla.minLengthArray(target, nums);
        System.out.printf(Integer.toString(res));
    }
}