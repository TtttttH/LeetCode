package easy;

import java.util.*;

/**
 * No.349:两个数组的交集
 */
public class No_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer i : resultSet) {
            result[index] = i;
            index ++;
        }
        return result;
    }
}
