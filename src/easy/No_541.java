package easy;

/**
 * No.541: 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class No_541 {

    public String reverseStr(String s, int k) {
        char[] charStr = s.toCharArray();
        int start = 0;
        while (start < s.length()) {
            if (start + k < s.length()) {
                reverse(charStr, start, start + k -1);
            } else {
                reverse(charStr, start, s.length() -1);
            }
            start = start + 2 * k;
        }
        return new String(charStr);
    }

    private void reverse(char[] c, int left, int right) {
        while (left <= right) {
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left ++;
            right --;
        }
    }
}
