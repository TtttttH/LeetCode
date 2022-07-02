package middle.backtrack;

/**
 * No.752 打开转盘锁 (Microsoft)
 */
public class No_752 {
    //todo
    int res = Integer.MAX_VALUE;
    public int openLock(String[] deadends, String target) {
        StringBuilder sb = new StringBuilder("0000");
        backtrack(deadends, target, sb, 0);

        return res;
    }

    private void backtrack(String[] deadends, String target, StringBuilder sb, int step) {
        if (sb.toString().equals(target)) {
            res = Math.min(step, res);
            return;
        }

        if (!isValid(deadends, sb)) return;
        for (int i = 0; i < 4; i ++) {
            char ch = sb.charAt(i);
            if (ch == target.charAt(i)) continue;
            char add = ch == '9' ? '0' : (char)(ch + 1);
            char minus = ch == '0' ? '9' : (char)(ch - 1);
            sb.setCharAt(i, add);
            backtrack(deadends, target, sb, step + 1);
            sb.setCharAt(i, minus);
            backtrack(deadends, target, sb, step + 1);
            sb.setCharAt(i, ch);
        }
    }

    private boolean isValid(String[] deadends, StringBuilder sb) {
        for (String deadend : deadends) {
            if (sb.toString().equals(deadend)) return false;
        }
        return true;
    }
}
