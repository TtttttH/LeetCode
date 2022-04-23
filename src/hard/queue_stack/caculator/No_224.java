package hard.queue_stack.caculator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.224 基本计算器(Microsoft)
 */
public class No_224 {
    public int calculate(String s) {
        s = s.trim();
        Deque<Character> optStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        int res = 0;
        int num = 0;
        int i = 0;
        char[] ch = s.toCharArray();
        while (i < ch.length) {
            char c = ch[i];
            if (c == '(') {
                optStack.push(c);
                i ++;
            } else if (c == ')') {
                while (!optStack.isEmpty()) {
                    char opt = optStack.peek();
                    if (opt != '(') {
                        calc(numStack, optStack);
                    } else{
                        optStack.pop();
                        break;
                    }
                }
                i ++;
            } else if (Character.isDigit(c)) {
                int j = i;
                while (j < ch.length && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + ch[j ++] - '0';
                }
                numStack.push(num);
                num = 0;
                i = j + 1;
            } else {
                optStack.push(c);
                i ++;
            }
        }

        while (!optStack.isEmpty()) calc(numStack, optStack);
        return numStack.pop();
    }

    private void calc(Deque<Integer> numStack, Deque<Character> optStack) {
        int a = numStack.pop(), b = numStack.pop();
        char opt = optStack.pop();
        a = opt == '+' ? a + b : b - a;
        numStack.push(a);
    }
}
