package design.limitProblem;

/**
 * 限流问题解决方案之一:漏桶算法(主要面对正常流量时候得处理，不适合面对突发大流量，因为处理速度恒定)
 * 思路:请求队列有个恒定的最大容量，单位时间请求的次数是不确定的，但是处理的速度是恒定的，新的请求到达时，判断当前请求容量已经
 * 达到最大，如果最大则丢弃(拒绝)当前新到达的请求
 */
public class LeakyBucket {
    private long rate; // 每秒处理数

    private long capacity; // 桶容量

    private long refreshTime; //最后刷新时间

    private long currentWater; //当前剩余请求量

    public boolean leakyBuketLimitRequire() {
        long currentTime = System.currentTimeMillis();
        long outWater = (currentTime - refreshTime) / 1000 * rate; //计算上次刷新时间到当前排出的请求量
        currentWater = Math.max(0, currentWater - outWater);
        //小于最大容量，请求放行
        if (currentWater < capacity) {
            currentWater ++;
            return true;
        }

        return false;
    }
}
