package middle.backtrack;

import java.util.*;

/**
 * github.com/labuladong/fucking-algorithm/blob/master/算法思维系列/回溯算法详解修订版.md
 * No.17
 */
public class LetterCombinations {
    //创建一个全局list来保存字符串结果
    List<String> result = new ArrayList<>();
    //应该用StringBuilder!不要直接用String一直占用新内存!
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtracking(digits, map, 0);
        return result;

    }

    private void backtracking(String digits, Map<Character, String> map, int digitIndex) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        Character number = digits.charAt(digitIndex);
        String letters = map.get(number);

        for (int i = 0; i < letters.length(); i ++) {
            sb.append(letters.charAt(i));
            backtracking(digits, map, digitIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        String digits = "23";
        System.out.printf(lc.letterCombinations(digits).toString());
    }
}
