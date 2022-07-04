package contest.NIO_300;

import java.util.LinkedList;
import java.util.List;

/**
 * 知道秘密的人数
 */
public class Solution_3 {
    static int MOD = (int) 1e9 + 7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1; //第i日新增的知道秘密的人
        long ans = 0L;
        for (int i = 2; i <= n; i ++) {
            for (int j = i - delay; j > 0 && j + forget > i; j --) {
                dp[i] += dp[j] % MOD;
            }
        }

        int t = forget;
        while (n >= 0 && t >= 1) {
            ans = (ans + dp[n]) % MOD;
            n --;
            t --;
        }

        return (int) ans;

    }

    public static void main(String[] args) {
        Solution_3 test = new Solution_3();
        System.out.println(test.peopleAwareOfSecret(6, 2, 4));
    }
}
