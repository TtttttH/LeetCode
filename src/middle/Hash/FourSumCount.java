package middle.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * No.454 四数相加||
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map12 = new HashMap<>();
        Map<Integer, Integer> map34 = new HashMap<>();
        int result = 0;
        computeNumMap(nums1, nums2, map12);
        computeNumMap(nums3, nums4, map34);

        for (int i : map12.keySet()) {
            if (map34.containsKey(-i)) {
                result += map12.get(i) * map34.get(-i);
            }
        }
        return result;
    }

    private void computeNumMap(int[] nums1, int[] nums2, Map<Integer, Integer> map) {
        for (int i  : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }
}
