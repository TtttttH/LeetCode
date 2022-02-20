package middle.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * No.22 括号生成 (middle)
 */
public class No_22 {
    List<String> results = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(n, 0, 0, sb);
        return results;
    }

    private void backtrack(int n, int open, int close, StringBuilder sb) {
        if (sb.length() == n * 2) {
            results.add(new String(sb));
            return;
        }

        if (open < n) {
            sb.append('(');
            backtrack(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open > close) {
            sb.append(')');
            backtrack(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
