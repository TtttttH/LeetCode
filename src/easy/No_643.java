package easy;

/**
 * No.643 Maximum Average SubArray I (easy) Microsoft
 * train of thought: slide window
 */
public class No_643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i ++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i ++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }

        return 1.0 * max / k;
    }
}
