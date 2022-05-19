package contest.double76th;

public class No_2 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for (long i = 0; i <= total / cost1; i ++) {
            res += (total - i * cost1) / cost2 + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        No_2 test = new No_2();
        System.out.println(test.waysToBuyPensPencils(1000000, 1, 1));
    }

//    private void dfs(int total, int cost1, int cost2, int a, int b) {
//        if (a * cost1 + b * cost2 <= total) {
//            res ++;
//        } else {
//            return;
//        }
//
//        for (int i = 0; i <= total / cost1; i ++) {
//            for (int j = 0; j <= total / cost2; j ++) {
//
//            }
//        }
//    }
}
