package easy;

/**
 * No.557 反转字符串中的单词III (Microsoft)
 */
public class No_557 {
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int start = i;
            while (i < s.length() && s.charAt(i) != ' ') i ++;
            for (int j = start; j < i; j ++) {
                sb.append(s.charAt(start + i - j - 1));
            }
            if (i < s.length()) {
                sb.append(' ');
                i ++;
            }
        }

        return sb.toString();
    }

    /**
     * 第一次版本
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        while(s.charAt(0) == ' ') s = s.substring(1);
        while(s.charAt(s.length() - 1) == ' ') s = s.substring(0, s.length() - 2);
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (s.charAt(right) == ' ') {
                while (right < s.length() && s.charAt(right) == ' ') right ++;
                left = right;
            } else {
                while (right < s.length() && s.charAt(right) != ' ') right ++;
                sb.append(reverse(s, left, right)).append(' ');
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private StringBuilder reverse(String s, int left, int right) {
        String sub = s.substring(left, right);
        StringBuilder sb = new StringBuilder(sub);
        return sb.reverse();
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        No_557 test = new No_557();
        System.out.println(test.reverseWords2(s));
    }
}
