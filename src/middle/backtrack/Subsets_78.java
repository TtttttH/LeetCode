package middle.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * No.78 子集
 */
public class Subsets_78 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        backtracking(nums, 0);
        return results;
    }

    private void backtracking(int[] nums, int startIndex) {
        results.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i ++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
