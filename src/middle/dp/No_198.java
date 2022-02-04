package middle.dp;

/**
 * No.198 打家劫舍
 */
public class No_198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        No_198 test = new No_198();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(test.rob(nums));
    }
}
