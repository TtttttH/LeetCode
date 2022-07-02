package middle.Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * No.442
 */
public class No_442 {
    //原地哈希
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) { //num in [1, n]
            nums[(num - 1) % n] += n;
        }

        for (int i = 0; i < n; i ++) {
            if (nums[i] > 2 * n)  res.add(i);
        }

        return res;
    }
}
