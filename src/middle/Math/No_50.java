package middle.Math;

/**
 * No.50 Pow(x, n) （shopee)
 */
public class No_50 {
    public double myPow(double x, int n) {
        double res = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                //存在奇数个待乘因子
                res *= x;
            }
            x *= x;
        }

        return n < 0 ? 1 / res : res;
    }
}
