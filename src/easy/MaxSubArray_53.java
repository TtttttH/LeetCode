package easy;

/**
 * No.53 最大子数组合
 */
public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
        for (int i : nums) {
            if (sum > 0) {
                sum += i;
            } else {
                sum = i;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
