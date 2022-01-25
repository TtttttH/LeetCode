package middle.greedy;

/**
 * No.134 加油站
 */
public class No_134 {

    //局部最优: 当前累加剩余油量之和curSum小于0的话，就一定不能在当前位置及其以前起始
    //全局最优: 走完全部节点的剩余油量大于等于0，及可以走完全程
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int start = 0;
        int curSum = 0;//起始点发车后的当前剩余油量
        int totalSum = 0;//全程走完的累计剩余油量
        for (int i = 0; i < gas.length; i ++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }

        return totalSum < 0 ? -1 : start;
    }
}
