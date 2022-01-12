package middle.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * No.131 分割回文串 （难度可以算hard)
 */
public class Partition_131 {

    List<List<String>> results = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return results;
        }

        backtracking(s, 0);
        return results;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            results.add(new ArrayList<>(path));
            return ;
        }

        for (int i = startIndex; i < s.length(); i ++) {
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
                backtracking(s, i + 1);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start ,int end) {
        for (int i = start, j = end; i < j; i ++, j --) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
