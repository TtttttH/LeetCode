package contest.double78;

public class Solution1 {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int res = 0;
        for (int i = 0; i <= s.length() - k; i ++) {
            int val = Integer.parseInt(s.substring(i, i + k));
            if (val != 0 && num % val == 0) res ++;
        }

        return res;
    }
}
