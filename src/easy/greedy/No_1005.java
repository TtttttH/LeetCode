package easy.greedy;

import java.util.Arrays;

/**
 * No.1005 K次取反后最大化的数组和
 */
public class No_1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums); //这里更优化的思路是按绝对值从大到小排序，这样可以省略掉下面k还是大于0的时候重新排序一次
        for (int i = 0; i < nums.length;i ++) {
            if (nums[i] >=0 || k == 0) {
                break;
            } else {
                nums[i] = -nums[i];
                k --;
            }
        }

        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}
