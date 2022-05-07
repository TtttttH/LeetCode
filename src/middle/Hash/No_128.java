package middle.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * No.128 最长连续序列(Microsoft)
 */
public class No_128 {
    /**
     * @Theoru: 首先使用set进行去重，然后开始遍历所有元素，如果一个元素没有前一个
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cnt = 1;
                while (set.contains(num + 1)) {
                    num ++;
                    cnt ++;
                }
                res = Math.max(res, cnt);
            }
        }

        return res;
    }
}
