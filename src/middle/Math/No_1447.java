package middle.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * No.1447 最简分数
 * 本题的核心思路: 判断两数互质-> 辗转相除法
 */
public class No_1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i < n; i ++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    results.add(i + "/" + j);
                }
            }
        }

        return results;
    }

    private int gcd(int a, int b) {
        return b == 0? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        No_1447 test = new No_1447();
        List<String> results = test.simplifiedFractions(100);
        for (String s : results) {
            System.out.println(s);
        }
    }
}
