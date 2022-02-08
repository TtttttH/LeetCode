package middle.dp;

/**
 * No.647 回文子串
 */
public class No_647 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            for (int j = i; j < s.length(); j ++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        result ++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        result ++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return result;
    }
//    public int countSubstrings(String s) {
//        int[][] dp = new int[s.length() + 1][s.length() + 1];
//        int result = 0;
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = i; j <= s.length(); j ++) {
//                if (isPalindrome(s, i - 1, j - 1)) {
//                    dp[i][j] = dp[i][j - 1] + 1;
//                }
//            }
//            result += dp[i][s.length()];
//        }
//
//        return result;
//    }
//
//    private boolean isPalindrome(String s, int start, int end) {
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            } else {
//                start ++;
//                end --;
//            }
//        }
//
//        return true;
//    }
}
