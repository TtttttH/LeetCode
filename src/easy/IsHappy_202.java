package com.achui.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * No.202 快乐数
 */
public class IsHappy_202 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    private int getNextNum(int n) {
        int res = 0;
        while(n > 0) {
            int temp = n % 10;
            res = res + temp * temp;
            n = n / 10;
        }
        return res;
    }
}
