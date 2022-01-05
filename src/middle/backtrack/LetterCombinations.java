package middle.backtrack;

import java.util.*;

/**
 * github.com/labuladong/fucking-algorithm/blob/master/算法思维系列/回溯算法详解修订版.md
 * No.17
 */
public class LetterCombinations {
    //创建一个全局list来保存字符串结果
    List<String> result = new ArrayList<>();

    public  List<String> letterCombination(String digits) {
        if (digits == null || digits.length() ==0) {
            return result;
        }

        Map<Character, String> numWords = new HashMap<>();
        numWords.put('2', "abc");
        numWords.put('3', "def");
        numWords.put('4', "ghi");
        numWords.put('5', "jkl");
        numWords.put('6', "mno");
        numWords.put('7', "pqrs");
        numWords.put('8', "tuv");
        numWords.put('9', "wxyz");
        dfs(numWords, digits, 0, "");
        return result;
    }

    private void dfs(Map<Character, String> numWords, String digits, int deep, String str) {
        if (str.length() == digits.length()) {
            //当拼接字符串长度等于输入数字字符串长度时，添加到结果集，返回上一层
            result.add(str);
            return;
        }
        String temp = numWords.get(digits.charAt(deep));
        for(int i = 0; i < temp.length(); i ++) {
            //深度+1,向下继续遍历
            dfs(numWords, digits, deep+1, str + temp.charAt(i));
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        String digits = "23";
        System.out.printf(lc.letterCombination(digits).toString());
    }
}
