package hard.backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * No.52 N皇后II
 */
public class No_52 {
    Set<Integer> column = new HashSet<>();
    Set<Integer> diagonals1 = new HashSet<>();
    Set<Integer> diagonals2 = new HashSet<>();
    int cnt = 0;
    public int totalNQueens(int n) {
        backtrack(0, n);
        return cnt;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            cnt ++;
            return;
        }

        for (int i = 0; i < n; i ++) {
            if (column.contains(i)) continue;
            int diagonal1 = i + row;
            if (diagonals1.contains(diagonal1)) continue;
            int diagonal2 = i - row;
            if (diagonals2.contains(diagonal2)) continue;
            column.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backtrack(row + 1, n);
            column.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }
}
