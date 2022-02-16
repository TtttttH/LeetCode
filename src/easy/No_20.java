package easy;

import java.util.Deque;
import java.util.LinkedList;

public class No_20 {

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i ++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '[') {
                deque.push(']');
            } else if (ch == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || ch!= deque.peek()) {
                return false;
            }
        }
        return true;
    }
//    public boolean isValid(String s) {
//        Deque<Character> queue = new LinkedList<>();
//        char[] chars = s.toCharArray();
//        for(int i = 0; i < s.length(); i ++) {
//            if (queue.isEmpty()) {
//                queue.push(s.charAt(i));
//            } else {
//                char top = queue.peek();
//                char newChar = s.charAt(i);
//                if (valid(top, newChar)) {
//                    queue.pop();
//                } else {
//                    queue.push(s.charAt(i));
//                }
//            }
//        }
//
//        return queue.isEmpty();
//    }
//
//    private boolean valid(char a, char b) {
//        if (a== '(' && b == ')') {
//            return true;
//        }
//        if (a == '{' && b == '}') {
//            return true;
//        }
//        if (a == '[' && b == ']') {
//            return true;
//        }
//        return false;
//    }
}
