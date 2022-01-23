package middle.bitCompute;

/**
 * No.137 只出现一次的数字II
 */
public class No_137 {
    //位运算
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
         for (int i : nums) {
             b = ~a & (b ^ i);
             a = ~b & (a ^ i);
         }

         return b;
    }
}
