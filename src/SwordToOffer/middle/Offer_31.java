package SwordToOffer.middle;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.31 栈的压入，弹出序列
 */
public class Offer_31 {
    public static boolean validateStackSequence(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i ++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j ++;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(Offer_31.validateStackSequence(pushed, popped));
    }
}
