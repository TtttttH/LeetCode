package hard.queue_stack.caculator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.227 基础计算器II (Microsoft)
 */
public class No_227 {
    public static int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
//        Deque<Character> ops = new LinkedList<>();
        s = s.replace(" ", "");
        char[] ch = s.toCharArray();
        int len = s.length();
        int i  = 0;
        while (i < len) {
            char c = ch[i];
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < len && Character.isDigit(ch[i])) {
                    num = num * 10 + ch[i ++] - '0';
                }

                nums.push(num);
            } else if (c == '*' || c == '/'){
                int a = nums.pop();
                int b = 0;
                i ++;
                while (i < len && Character.isDigit(ch[i])) {
                    b = b * 10 + ch[i ++] - '0';
                }
                nums.push(c == '*' ? a * b : a / b);
            } else if (c == '-'){
                int b = 0;
                i ++;
                while (i < len && Character.isDigit(ch[i])) {
                    b = b * 10 + ch[i ++] - '0';
                }
                nums.push(-1 * b);
            } else {
                i ++;
            }
        }

        while (nums.size() >= 2) {
            int b = nums.pop();
            int a = nums.pop();
            nums.push(a + b);
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        String s = "3 + 2 * 2";
        No_227.calculate(s);
    }
}
