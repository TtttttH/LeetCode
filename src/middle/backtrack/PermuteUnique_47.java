package middle.backtrack;

import java.util.*;

/**
 * No.47 全排列II
 */
public class PermuteUnique_47 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    //用来做树枝和树层排重
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
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
            //前面是树枝排重,||后是树层排重
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            set.add(nums[i]);
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }

}
