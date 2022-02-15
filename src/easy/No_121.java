package easy;

/**
 * 回文数 121->true; 10->false
 */
public class No_121 {

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x / 10 == 0 && x != 0)) {
            return false;
        }

        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertNumber || x == revertNumber / 10;
    }

    public static void main(String[] args) {
        int i = -10;
        int y = -32;
        System.out.println(isPalindrome(i));
    }
}