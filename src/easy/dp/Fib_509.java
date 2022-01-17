package easy.dp;

/**
 * No.509 斐波那契数
 */
public class Fib_509 {

    //递归效率比较低,迭代更快
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0, b = 1, sum = 0;
        for (int i = 1; i < n; i ++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }
}
