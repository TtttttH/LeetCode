package middle.doublepoint;

/**
 * No.647 回文子串
 */
public class No_647 {
    public int countSubstrings(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < s.length(); i ++) {
            result += extend(s, i, i);
            result += extend(s, i, i + 1);
        }

        return result;
    }

    private int extend (String s, int left ,int right) {
        int result = 0;
        while(left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            result ++;
            left --;
            right ++;
        }

        return result;
    }
}
