package hard.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * No.51 N皇后
 */
public class SolveNQueens_51 {

    List<List<String>> results = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int[] path;
    Set<Integer> columns = new HashSet<>();
    Set<Integer> diagonals1 = new HashSet<>();
    Set<Integer> diagonals2 = new HashSet<>();

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
            if (columns.contains(i)) {
                continue;
            }

            int diagonal1 = rowNum - i;
            int diagonal2 = rowNum + i;
            if (diagonals1.contains(diagonal1) || diagonals2.contains(diagonal2)) {
                continue;
            }

            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            path[rowNum] = i;
            backtracking(n, rowNum + 1);
            path[rowNum] = -1;
            diagonals2.remove(diagonal2);
            diagonals1.remove(diagonal1);
            columns.remove(i);
        }
    }
}
