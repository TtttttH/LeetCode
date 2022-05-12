package easy;

import java.util.List;

/**
 * 面试题08.06 汉诺塔问题(Microsoft)
 */
public class Hanota {
    /**
     * theory: 拆分子问题，递归思想
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int target = A.size();
        move(target, A, B, C);
    }

    private void move(int target, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (target == 1) {
            C.add( A.remove(A.size() - 1));
            return;
        }

        move(target - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(target - 1, B, A, C);
    }
}
