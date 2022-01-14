package middle.backtrack;

import java.util.*;

/**
 * No.47 全排列II
 */
public class PermuteUnique_47 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    //用来做树枝排重
    Set<Integer> indexSet = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return results;
        }

        backtracking(nums);
        return results;
    }

    private void backtracking(int[] nums) {
        //需要树层排重和树枝排重
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }

        //用来做树层排重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (indexSet.contains(i) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            indexSet.add(i);
            path.add(nums[i]);
            backtracking(nums);
            path.removeLast();
            indexSet.remove(i);
        }
    }

}
