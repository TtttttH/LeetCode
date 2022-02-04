package middle.dp;

import java.util.List;

/**
 * No.139 单词拆分
 */
public class No_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; //初始化为false;
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;//找到可行的组合，跳出j的循环
                }
            }
        }

        return dp[s.length()];
    }
}
