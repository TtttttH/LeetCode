package middle.dp;

/**
 * No.377 组合问题IV
 */
public class No_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i ++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
//                    System.out.println("dp[" + i + "]:" + dp[i]);
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        No_377 test = new No_377();
        int[] nums = {1,2,3};
        int target = 4;
        test.combinationSum4(nums, target);
    }
}
