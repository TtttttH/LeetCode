package com.achui.leetcode.easy;

/**
 * No.344 反转字符串:不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
 */
public class ReverseString_344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        char temp = ' ';
        while (left <= right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }
}
