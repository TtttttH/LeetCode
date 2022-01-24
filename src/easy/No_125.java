package easy;

import java.util.HashMap;

/**
 * No.125 验证回文串
 */
public class No_125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append(Character.toLowerCase(ch));
            }
        }

        int left = 0;
        int right = sb.length() - 1;
        while(left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            } else {
                left ++;
                right --;
            }
        }
        return true;
    }
}
