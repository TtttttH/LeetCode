package middle.Math;

import java.util.Random;

/**
 * No.470 用Rand7() 实现 Rand10() (Microsoft)
 */
public class No_470 {
    int rand7() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    public int rand10() {
        int val = 0;
        do {
            val = (rand7() - 1) * rand7() + rand7();
        } while (val < 40);
        return 1 + val % 10;
    }
}
