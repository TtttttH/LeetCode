package easy;

/**
 * No.392 判断子序列
 */
public class No_392 {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length() - 1;
        int tlen = t.length() - 1;

        while(slen >= 0 && tlen >=0) {
            if (t.charAt(tlen) == s.charAt(slen)) {
                slen --;
                tlen --;
            } else {
                tlen --;
            }
        }

        return slen < 0;
    }
}
