package middle.dp;

/**
 * No.494 Target Sum
 */
public class No_494 {
    public int findTargetSumWays(int[] nums, int target) {
        /**
         * 采用01背包问题解法, 得到结果target可以转化为将nums数组分成left和right两部分
         * 题意中nums中元素均>=0, 故判断时候可以知道sum < abs(target) 时候无组合满足条件
         * left - right(即right部分取负) = target
         * left + right = sum
         * 2*left = target + sum
         * left = (target + sum) / 2
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < Math.abs(target) || (target + sum) % 2 != 0) {
            return 0;
        }
        int posSum = (target + sum) / 2;
        int[] dp = new int[posSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = posSum; j >= num; j --) {
                dp[j] = dp[j] + dp[j - num];
            }
        }

        return dp[posSum];
    }
}
