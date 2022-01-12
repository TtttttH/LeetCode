package middle.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * No.40 组合总和II
 */
public class CombinationSum2_40 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return results;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            results.add(new ArrayList<>(path));
            return ;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i ++) {
            //这里用startIndex对树层去重
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i+1);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
