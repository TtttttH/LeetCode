package middle.sort;

import java.util.ArrayList;
import java.util.List;

public class No_386 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 0; i <= 9; i ++) {
            dfs(i, n);
        }

        return res;
    }

    private void dfs(int cur, int n) {
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i <= 9; i ++) {
            if (cur * 10 + i > n) break;
            dfs(cur*10 + i, n);
        }
    }

    public List<Integer> lexicalOrder_traversal(int n) {
        for (int i = 0, j = 1; i < n; i ++) {
            res.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j + 1 > n) j /= 10;
                j ++;
            }
        }

        return res;
    }
}
