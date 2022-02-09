package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * No.2006 Count Number of Pairs With Absolute Difference K
 */
public class No_2006 {
    public int countDifference(int[] nums, int k) {
        //暴力可以ac,推荐哈希法
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (map.containsKey(num + k)) {
                count += map.get(num + k);
            }

            if (map.containsKey(num - k)) {
                count += map.get(num - k);
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
//        int count = 0;
//        for (int i = 0; i < nums.length; i ++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (Math.abs(nums[i] - nums[j]) == k) {
//                    count ++;
//                }
//            }
//        }
//
//        return count;
    }
}
