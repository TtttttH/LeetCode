package contest.double76th;

/**
 * No.3
 */
public class ATM {

    long[] store;
    public ATM() {
        store = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i ++) {
            store[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] denomination = {20, 50, 100, 200, 500};
        int[] res = new int[5];
        for (int i = 4; i >= 0; i --) {
            if (amount / denomination[i] <= store[i]) {
                res[i] = amount / denomination[i];
                store[i] -= res[i];
                amount %= denomination[i];
            } else {
                res[i] = (int)store[i];
                store[i] = 0;
                amount -= res[i] * denomination[i];
            }
        }

        if (amount != 0) {
            for (int i = 0; i < 5; i ++) {
                store[i] += res[i];
            }
            return new int[] {-1};
        }
        else return res;
    }
}
