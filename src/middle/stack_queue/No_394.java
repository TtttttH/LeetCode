package middle.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.394 字符串解码(Microsoft)
 */
public class No_394 {
    public String decodeString(String s) {
        Deque<StringBuilder> chStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                num = ch - '0' + 10 * num;
            } else if (ch == '[') {
                numStack.push(num);
                chStack.push(ans);
                ans = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder temp = chStack.pop();
                int time = numStack.pop();
                for (int i = 0; i < time; i ++) {
                    temp.append(ans);
                }
                ans = temp;
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
