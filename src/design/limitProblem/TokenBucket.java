package design.limitProblem;

import java.util.ArrayList;

/**
 * 限流问题解决方案:令牌桶算法(tokenBucket)
 * 生成令牌的速度是恒定的，而请求去拿令牌是没有速度限制的。
 * 这意味，面对瞬时大流量，该算法可以在短时间内请求拿到大量令牌，而且拿令牌的过程并不是消耗很大的事情。
 */
public class TokenBucket {
    private long permitTokenRate; //单位时间令牌发放数量

    private long refreshTime; //上次刷新时间

    private long capacity; //令牌桶容量

    private long currentToken = 0L; //当前桶内token数量

    public boolean tokenBucketLimitRequire() {
        long currentTime = System.currentTimeMillis();
        long generateToken = (currentTime - refreshTime) / 1000 * permitTokenRate;

        currentToken = Math.min(capacity, currentToken + generateToken);
        if (currentToken > 0) {
            currentToken --; //如果当前桶中还有token的话
            return true;
        }

        return false;
    }
}
