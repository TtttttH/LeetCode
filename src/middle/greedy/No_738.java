package middle.greedy;

/**
 * No.738 Monotone Increasing Digits
 */
public class No_738 {
    public int monotoneIncreasingDigits(int n) {
        if (n == 0) {
            return 0;
        }

        char[] chars = Integer.toString(n).toCharArray();
        int startNine = Integer.MAX_VALUE;
        for (int i = chars.length - 1; i > 0; i --) {
            if (chars[i] < chars[i - 1]) {
                chars[i - 1] --;
                startNine = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == '0' && i == 0) {
                continue;
            }

            if (i < startNine) {
                sb.append(chars[i]);
            } else {
                sb.append('9');
            }
        }

        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args) {
        int n = 100;
        No_738 test = new No_738();
        int output = test.monotoneIncreasingDigits(n);
        System.out.println(output);
    }
}
