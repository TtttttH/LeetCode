package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.155 Min Stack
 */
public class No_155 {
    //不适用额外空间！只使用一个栈实现方法,这里栈存储当前值和最小值得差值，如果大于0那么及为min+diff,否则最小值及为当前值
    Deque<Long> stack;
    long min;
    public No_155() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            long diff = val - min;
            stack.push(diff);
            min = diff > 0? min : val;
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            long diff = stack.pop();
            min = diff > 0? min : min - diff;
        }
    }

    public int top() {
        long diff = stack.peek();
        return (int) (diff > 0 ? min + diff : min);
    }

    public int getMin() {
        return (int) min;
    }
}
