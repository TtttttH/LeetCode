package easy;

import java.util.Arrays;

/**
 * No.917 仅仅反转字母
 */
public class No_917 {
    public String reverseOnlyLetters(String s) {
        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!Character.isLetter(chars[left])) left ++;
            while (!Character.isLetter(chars[right])) right --;
            if (left >= right) break;
            char temp = chars[left];
            chars[left ++] = chars[right];
            chars[right --] = temp;
        }

        return new String(chars);
    }
}
