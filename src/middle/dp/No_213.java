package middle.dp;

/**
 * No.213 打家劫舍II
 */
public class No_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
//        if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
        return Math.max(robAction(nums, 0, nums.length - 1), robAction(nums, 1, nums.length));
    }

    private int robAction(int[] nums, int start, int end) {
        int a = 0, b = 0, c = 0; // a:dp[i - 2], b:dp[i - 1], c:dp[i]
        for (int i = start; i < end; i ++) {
            b = c;
            c = Math.max(b, a + nums[i]);
            a = b;
        }

        return c;
//        int[] dp = new int[nums.length];
//        dp[start] = nums[start];
//        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
//        for (int i = start + 2; i < end; i ++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//
//        return dp[end - 1];
    }
}
