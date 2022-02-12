package middle.doublepoint;

/**
 * No.5 最大回文子串
 */
public class No_5 {
    int left = 0, right = 0, maxLength = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i ++) {
            extend(s, i, i, s.length());
            extend(s, i, i + 1, s.length());
        }

        return s.substring(left, right - 1);
    }

    private void extend(String s, int i, int j, int len) {
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            if (j - i + 1 > maxLength) {
                left = i;
                right = j;
                maxLength = j - i + 1;
            }

            i --;
            j ++;
        }
    }
}
