package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个32位有符号数，将这个整数中每位上的数字进行翻转
 */

public class ReverseInteger {

    public static int reverse(int x) {
//        int sum = 0;
//        int i = 0;
//        List<Integer> a = new ArrayList<>();
//        while(x != 0) {
//            a.add(x%10);
//            x = x/10;
//        }
//        for(Integer j : a) {
//            sum = sum*10 + j;
//        }
//
//        return sum;

        int res = 0;
        while(x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 253;
        System.out.println(reverse(a));
    }
}
