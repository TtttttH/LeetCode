package middle.bitCompute;

import java.util.ArrayList;
import java.util.List;

/**
 * No.89 格雷编码
 * 数学原理：G(i) = B(i+1) ^ B(i)    G:格雷数  B:二进制数 B(i+1) = B(i) >> 1
 */
public class No_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i ++) {
            result.add((i >> 1) ^ i);
        }

        return result;
    }
}
