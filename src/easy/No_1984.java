package easy;

import java.util.Arrays;

/**
 * No.1984 Minimum Difference Between Highest and Lowest of K Scores
 */
public class No_1984 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1 || nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - k + 1; i ++) {
            int temp = nums[i + k - 1] - nums[i];
            result = Math.min(result, temp);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 3, 5, 7};
        No_1984 test = new No_1984();
        System.out.println(test.minimumDifference(nums, 2));
    }
}
