package middle.String;

/**
 * kmp算法实现strStr()
 */
public class KMPstr_28 {
    //获取next数组
    public void getNext(int[] next, String s) {
        //初始化j
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i ++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j ++;
            }
            next[i] = j;
        }
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = -1;
        for (int i = 0; i < haystack.length(); i ++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) { // 不匹配
                j = next[j]; //j寻找之前匹配的位置
            }

            if (haystack.charAt(i) == needle.charAt(j + 1)) { //匹配, j 和 i同时向后移动
                j ++;
            }

            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }

        return -1;
    }
}
