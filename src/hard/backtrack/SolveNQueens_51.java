package hard.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * No.51 N皇后
 */
public class SolveNQueens_51 {

    List<List<String>> results = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int[] path;
    boolean flag = true;
    public List<List<String>> solveNQueens(int n) {
        path = new int[n];
        for (int i = 0; i < n; i ++) {
            path[i] = -1;
            sb.append('.');
        }

        backtracking(n, 0);
        return results;
    }

    private void backtracking(int n, int rowNum) {
        if (rowNum == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int pos : path) {
                StringBuilder sb1 = new StringBuilder(sb);
                sb1.replace(pos, pos + 1, "Q");
                list.add(sb1.toString());
            }

            results.add(list);
            return;
        }

        for (int i = 0; i < n; i ++) {
            flag = true;
            if (rowNum > 0 ) {
                for (int j = 0; j < rowNum; j ++) {
                    if (i == path[j] || (rowNum - j) == Math.abs(i - path[j])) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                path[rowNum] = i;
                backtracking(n, rowNum + 1);
                path[rowNum] = -1;
            }
        }
    }
}
