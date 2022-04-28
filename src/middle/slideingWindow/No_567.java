package middle.slideingWindow;

import java.util.Arrays;

/**
 * No.567 字符串的排列 (Microsoft)
 */
public class No_567 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len2 < len1) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char ch : s1.toCharArray()) {
            count1[ch - 'a'] ++;
        }

        char[] chars = s2.toCharArray();
        for (int i = 0; i < len1; i ++) {
            count2[chars[i] - 'a'] ++;
        }

        for (int j = len1; j < len2; j ++) {
            if (Arrays.equals(count1, count2)) return true;
            count2[chars[j] - 'a'] ++;
            count2[chars[j - len1] - 'a'] --;
        }

        return Arrays.equals(count1, count2);
    }

//    private boolean equal(int[] count1, int[] count2) {
//        for (int i = 0; i < 26; i ++) {
//            if (count1[i] != count2[i]) return false;
//        }
//
//        return true;
//    }
}
