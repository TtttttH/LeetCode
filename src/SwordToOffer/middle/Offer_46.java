package SwordToOffer.middle;

/**
 * No.46 把数字翻译成字符串
 */
public class Offer_46 {
    public int translateNum(int num) {
        if (num < 10) return 1;
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < chars.length; i ++) {
            int val = (chars[i - 1] - '0') * 10 + (chars[i] -'0');
            if (val < 10 || val > 25) { //char[i - 1] = 0 || val > 26
                dp[i + 1] = dp[i];
            } else {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }
}
