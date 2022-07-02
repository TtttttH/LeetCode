package middle.simulation;

/**
 * No.393 UTF-8 编码验证 (middle)
 */
public class No_393 {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int t = data[i];
            int j = 7;
            while (j >= 0 && (((t >> j) & 1) == 1)) j --; //计算从开始连续1的个数，可以为0，2，3，4
            int cnt = 7 - j;
            if (cnt == 1 || cnt > 4) return false;
            int k = i + 1;
            while (k < i + cnt && ((data[k] >> 7 & 1) == 1) && (((data[k] >> 6 & 1) == 0))) k ++;
            if (k < i + cnt) return false;
            i += cnt;
        }

        return true;
    }
}
