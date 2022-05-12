package middle.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.1190 反转每对括号间的子串 (Microsoft)
 */
public class No_1190 {
    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == '(') stack.push(i);
            if (chars[i] == ')') {
                int left = stack.pop();
                reverse(chars, left, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch == '(' || ch == ')') continue;
            sb.append(ch);
        }

        return sb.toString();
    }

    private void reverse(char[] chars, int left, int right) {
        left ++;
        right --;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        No_1190 test = new No_1190();
        String s = "(u(love)i)";
        System.out.println(test.reverseParentheses(s));
    }

}
