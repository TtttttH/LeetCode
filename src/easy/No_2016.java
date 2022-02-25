package easy;

/**
 * No.2016 增量元素之间的最大差值 easy
 */
public class No_2016 {
    //思路:前缀最小值
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            if (num > min) {
                max = Math.max(max, num - min);
            }
        }
        return max;
//        int left = 0;
//        int minleft = 0;
//        int maxRight = 1;
//        int max = nums[maxRight] > nums[minleft] ? nums[maxRight] - nums[minleft] : -1;
//        for (int right = 2; right < nums.length; right ++) {
//            if (nums[right] >= nums[maxRight]) maxRight = right;
//            left ++;
//            if (nums[left] < nums[minleft]) {
//                minleft = left;
//                if (minleft > maxRight) maxRight = right;
//            }
//            if (minleft < maxRight && nums[maxRight] > nums[minleft]) {
//                max = Math.max(max, nums[maxRight] - nums[minleft]);
//            }
//        }
//
//        return max;
    }
}
