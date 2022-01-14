package middle.backtrack;

import java.util.*;

/**
 * No.491 递增子序列
 */
public class FindSubsequences_491 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) {
            return results;
        }

        backtracking(nums, 0);
        return results;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            results.add(new ArrayList<>(path));
        }

        //注意这里的数层去重,新建set去重
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i ++) {
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                continue;
            } else {
                if (set.contains(nums[i])) {
                    continue;
                }
                set.add(nums[i]);
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
