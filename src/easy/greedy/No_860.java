package easy.greedy;

/**
 * No.860 柠檬水找零
 */
public class No_860 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2]; // int[0] :5 , int[1] :10

        for (int bill : bills) {
            if (bill == 5) {
                money[0] ++;
            } else if (bill == 10) {
                money[1] ++;
                money[0] --;
            } else {
                if (money[1] > 0) {
                    money[0] --;
                    money[1] --;
                } else {
                    money[0] -= 3;
                }
            }

            if (money[0] < 0 || money[1] < 0) {
                return false;
            }
        }

        return true;
    }
}
