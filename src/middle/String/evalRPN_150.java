package middle.String;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.150 逆波兰式
 */
public class evalRPN_150 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        int a;
        int b;
        int res;
        for (String str : tokens) {
            if (!str.equals("+") && (!str.equals("-")) && (!str.equals("*")) && (!str.equals("/"))) {
                deque.push(Integer.parseInt(str));
            } else {
                a = deque.pop();
                b = deque.pop();
                if (str.equals("+")) {
                    res = a + b;
                    deque.push(res);
                }

                if (str.equals("-")) {
                    res = b - a;
                    deque.push(res);
                }

                if (str.equals(("*"))) {
                    res = a * b;
                    deque.push(res);
                }

                if (str.equals(("/"))) {
                    res = b / a;
                    deque.push(res);
                }
            }
        }
        return deque.pop();
    }
}
