package middle.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * No.90 子集II
 */
public class SubsetsWithDup_90 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);
        backtracking(nums, 0);
        return results;

    }

    private void backtracking(int[] nums, int startIndex) {
        if (!results.contains(path)) {
            results.add(path);
        }

        for (int i = startIndex; i < nums.length; i ++) {
            //数层去重 (需要数组为排列后数组)
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
