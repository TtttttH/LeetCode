package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * No.232 用栈实现队列
 *
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class No_232 {

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public No_232() {
        stack1 = new ArrayDeque<>(); // 负责进栈
        stack2 = new ArrayDeque<>(); // 负责出栈
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() || stack2.isEmpty();
    }
}
