package middle.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * No.560 和为K的子数组 (微软)
 * 前缀和+hash
 */
public class No_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0, res = 0;
        for (int i : nums) {
            sum += i;
            if (preSum.containsKey(sum - k)) { //说明map中有满足条件的前缀，使得该前缀后面到i的元素和为k
                res += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
