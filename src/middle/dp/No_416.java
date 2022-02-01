package middle.dp;

/**
 * No.416 Partition Equal Subset Sum
 */
public class No_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;
        int[] dp = new int[sum + 1];
        for (int num : nums) {
            for (int j = sum; j >= num; j --) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[sum] == sum;
//        int[][] dp = new int[len][sum + 1];
//        for (int i = 0; i < len; i ++) {
//            dp[i][0] = 0;
//        }
//        for (int j = sum; j > 0 ; j--) {
//            if (j < nums[0]) {
//                break;
//            }
//
//            dp[0][j] = nums[0];
//        }
//        for (int i = 1; i < len; i ++) {
//            for (int j = 1; j <= sum; j ++) {
//                if (j < nums[i]) {
//                    dp[i][j] = dp[i-1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
//                }
//            }
//        }
//
//        return dp[len - 1][sum] == sum;
    }
}
