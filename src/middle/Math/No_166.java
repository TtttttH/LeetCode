package middle.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * No.166 分数到小数(Microsoft)
 */
public class No_166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        StringBuilder res = new StringBuilder();
        if (a < 0 && b > 0 || a > 0 && b < 0) res.append('-'); //注意这里需要分开判断不能用除法结果，可能出现异号但是分子小于分母导致结果为0 的情况
        a = Math.abs(a);
        b = Math.abs(b);
        res.append(a / b);
        if (a % b == 0) return res.toString();
        res.append('.');
        Map<Long, Integer> map = new HashMap<>();
        a %= b;
        int i = 0;
        while(a % b > 0 && !map.containsKey(a)) {
            i ++;
            map.put(a, i);
            a = a * 10;
            res.append(a / b);
            a = a % b;
        }

        if (a == 0) return res.toString();
        res.insert(res.indexOf(".") + map.get(a), '(').append(')');
        return res.toString();
    }


    public static void main(String[] args) {
        int a = 7, b = -12;
        System.out.println(No_166.fractionToDecimal(a, b));
        System.out.println(7 / -12);
    }
}
