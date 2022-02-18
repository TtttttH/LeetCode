package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.350 两个数组的交集II
 */
public class No_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : (nums1.length < nums2.length? nums2 : nums1)) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for (int i : (nums1.length < nums2.length? nums1 : nums2)) {
            if (count.containsKey(i) && count.get(i) > 0) {
                list.add(i);
                count.put(i, count.get(i) - 1);
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for (int i : list) {
            result[index ++] = i;
        }

        return result;
    }
}
