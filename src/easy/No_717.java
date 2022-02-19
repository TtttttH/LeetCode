package easy;

/**
 * No.717 1比特与2比特字符
 */
public class No_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (i == bits.length - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i += 2;
            } else {
                i ++;
            }
        }

        return false;
    }
}
