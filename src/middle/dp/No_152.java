package middle.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * No.152 乘积最大子数组 (微软)
 * 刚开始思路是前缀积，结果没想出来，用二维dp int[n][2]记录正负最大数做，后面再简化成只记录当前最大最小值
 */
public class No_152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(max, res);
        }

        return res;
    }
}
