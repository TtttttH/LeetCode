package middle.Math;

import java.util.Arrays;

/**
 * No.204 计数质数 (Microsoft)
 */
public class No_204 {
    //技巧题，纯背诵，埃氏筛法
    public int countPrimes(int n) {
        int res = 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for (int i = 2; i < n; i ++) {
            if (prime[i]) {
                res ++;
                if ((long) i * i < n) {
                    for(int j = i * i; j < n; j += i) {
                        prime[j] = false;
                    }
                }
            }
        }

        return res;
    }
}
