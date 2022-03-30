package middle.slideingWindow;

/**
 * No.2024 考试中的最大难度 (middle)
 */
public class No_2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        if (answerKey.length() <= 2) return answerKey.length();
        return Math.max(getMaxContinuous(answerKey, k, 'T'), getMaxContinuous(answerKey, k, 'F'));
    }

    private int getMaxContinuous(String str, int k, char ch) {
        int res = 0;
        int sum = 0;
        for (int left = 0, right = 0; right < str.length(); right ++) {
            sum += str.charAt(right) == ch ? 0 : 1;
            while (sum > k) {
                sum -= str.charAt(left ++) == ch ? 0 : 1;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
