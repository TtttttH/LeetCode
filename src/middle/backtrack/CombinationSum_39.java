package middle.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  No.39 组合总和
 */
public class CombinationSum_39 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        //剪枝优化的话这里一定要先排序!!
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return results;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {

        if (sum == target) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i ++) {
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(candidates, target, sum, i);
            sum = sum - candidates[i];
            path.removeLast();
        }
    }
}
