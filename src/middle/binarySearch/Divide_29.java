package middle.binarySearch;

/**
 * No.29 两数相除
 */
public class Divide_29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean minerFlag = false;
        int result = 0;
        if (dividend < 0) {
            if (divisor > 0) {
                minerFlag = true;
                divisor = - divisor;
            }

            while (dividend <= divisor) {
                dividend -= divisor;
                result --;
            }
        } else {
            if (divisor < 0) {
                minerFlag = true;
            } else {
                divisor = -divisor;
            }

            dividend = - dividend;
            while (dividend <= divisor) {
                dividend -= divisor;
                result --;
            }
        }
        
        return minerFlag ? result : -result;
    }
}
