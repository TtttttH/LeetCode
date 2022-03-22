package middle.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * No.974 和可被K整除的子数组 微软
 * 思路: 前缀和问题(涉及到连续子数组以及数组存在负数的，不可以使用双指针滑动窗口)
 * (-9 % 5 = 1!,但是java里结果为-4)
 */
public class No_974 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            int temp = (sum % k + k) % k; // !一定要注意这里的取余规则处理，java的负数取余结果为负数，很坑
            if (preSum.containsKey(temp)) res += preSum.get(temp);
            preSum.put(temp, preSum.getOrDefault(temp, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, -2, 2, -4};
        No_974 test = new No_974();
        System.out.println(test.subarraysDivByK(nums, 6));
    }
}
