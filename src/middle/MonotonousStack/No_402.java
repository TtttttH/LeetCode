package middle.MonotonousStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.402 移掉K位数字 (Microsoft)
 */
public class No_402 {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        Deque<Character> stack = new LinkedList<>();
        char[] ch = num.toCharArray();
        stack.push(ch[0]);
        for (int i = 1; i < ch.length; i ++){
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch[i]) {
                stack.pop();
                k --;
            }

            if (ch[i] != '0' || !stack.isEmpty()) {
                stack.push(ch[i]);
            }
        }

        if (stack.isEmpty()) return "0";
        else {
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) sb.append(stack.pop());
            if (sb.length() <= k) return "0";
            return sb.reverse().substring(0, sb.length() - k);
        }
    }
}
