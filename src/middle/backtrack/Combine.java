package middle.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * No.77: 给定两个整数n 和 k,返回范围[1, n] 中所有可能的k个数的组合
 */
public class Combine {

    private List<List<Integer>> results = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return results;
        }

        backtracking(n, k, 1);
        return results;
    }

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            //这里一定要new list! 并且要return 结束递归
            results.add(new ArrayList<>(path));
            return;
        }

        //这里剪枝性能会提高很多!
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i ++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

}
