package middle.slideingWindow;

/**
 * No.424 替换后的最长重复字符
 */
public class No_424 {

    //TODO 这题解法第一时间很难理解
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, right = 0, n = s.length();
        int maxCnt = 0;
        char[] chars = s.toCharArray();
        while(right < n) {
            count[chars[right] - 'A'] ++;
            maxCnt = Math.max(maxCnt, count[chars[right] - 'A']);
            if (right - left + 1 - maxCnt> k) {
                count[chars[left] - 'A'] --;
                left ++;
            }

            right ++;
        }

        return right - left + 1;
    }
}
