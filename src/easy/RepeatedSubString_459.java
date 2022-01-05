package easy;

/**
 * No.459 重复的子字符串
 */
public class RepeatedSubString_459 {

    public void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j ++;
            }
            next[i] = j;
        }
    }
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int len = s.length();
        int[] next = new int[len];
        getNext(next, s);
        return (len % (len - (next[len - 1] + 1))) == 0;
    }
}
