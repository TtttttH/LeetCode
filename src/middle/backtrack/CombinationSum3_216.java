package middle.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * No.216 组合总合III
 */
public class CombinationSum3_216 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1);
        return results;
    }

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k && n == 0) {
            results.add(new ArrayList<>(path));
            return ;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i ++) { // 剪枝优化
            path.add(i);
            backtracking(n - i, k, i);
            path.removeLast();
        }
    }
}
