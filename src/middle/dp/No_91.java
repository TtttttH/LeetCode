package middle.dp;

/**
 * No.91 解码方法
 */
public class No_91 {
    public int numDecodings(String s) {
        char[] letters = s.toCharArray();
        int len = letters.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i ++) {
            dp[i + 1] = letters[i] == '0' ? 0 : dp[i];
            if (i > 0 && (letters[i - 1] == '1' || (letters[i - 1] == '2' && letters[i] < '7'))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }
    public int numDecodings_first_version(String s) {
        char[] letters = s.toCharArray();
        if (letters[0] == '0') return 0;
        int len = letters.length;
        if (len == 1) return 1;
        int[] dp = new int[len];
        dp[0] = 1;
        if (letters[1] == '0') {
            if (letters[0] > '2') return 0;
            else dp[1] = 1;
        } else if (letters[0] > '2' || (letters[0] == '2' && letters[1] > '6')) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }

        for (int i = 2; i < len; i ++) {
            if (letters[i] == '0' && letters[i - 1] > '2') return 0;
            int a = letters[i] == '0' ? 0 : dp[i - 1];
            int b = (letters[i - 1] == '2' && letters[i] <= '6') || (letters[i - 1] == '1') ? dp[i - 2] : 0;
            dp[i] = a + b;
        }

        return dp[len - 1];
    }
}
