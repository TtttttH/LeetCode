package middle.Math;

import java.util.Arrays;

/**
 * No.462 最少移动次数使数组元素相等II (Microsoft)
 */
public class No_462 {
    public int minMove2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int avg = nums[n / 2];
        int res = 0;

        for (int i = 0; i < nums.length; i ++) {
            res += Math.abs(avg - nums[i]);
        }

        return res;
    }
}
