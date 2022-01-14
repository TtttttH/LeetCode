package middle.backtrack;

import java.util.*;

/**
 * No.46 全排列
 */
public class Permute_46 {

    List<List<Integer>> results = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
//    Set<Integer> usedSet = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return results;
        }

        backtracking(nums);

        return results;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) { //用set去重的话这里就是usedSet
                continue;
            }

//            usedSet.add(num);
            path.add(num);
            backtracking(nums);
            path.removeLast();
//            usedSet.remove(num);
        }
    }
}
