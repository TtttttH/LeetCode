package easy.dp;

/**
 * No.674 最长连续递增序列
 */
public class No_674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[1];
        dp[0] = 1;
        int result = dp[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[0] = dp[0] + 1;
            } else {
                dp[0] = 1;
            }

            result = Math.max(result, dp[0]);
        }

        return result;
    }
}
