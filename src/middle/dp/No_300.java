package middle.dp;

/**
 * No.300 最长递增子序列
 */
public class No_300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i ++) {
            dp[i] = 1;
        }

        int result = dp[0];
        for (int i = 1; i < len; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                if (dp[i] > result) {
                    result = dp[i];
                }
            }
        }
        return result;
    }
}
