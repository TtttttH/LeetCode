package middle.Math;

/**
 * No.223 矩阵面积(Microsoft)
 */
public class No_223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int size1 = (ax2 - ax1) * (ay2 - ay1);
        int size2 = (bx2 - bx1) * (by2 - by1);
        if (ay2 <= by1 || ay1 >= by2 || ax1 >= bx2 || ax2 <= bx1) return size1 + size2;
        int length = Math.min(bx2, ax2) - Math.max(bx1, ax1);
        int width = Math.min(by2, ay2) - Math.max(by1, ay1);

        return size1 + size2 - length * width;
    }
}
