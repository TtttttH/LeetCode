package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.706 设计哈希映射 (Microsoft)
 */

//TODO 写的不够底层，需要重写
public class MyHashMap {
    List<int[]> map;
    public MyHashMap() {
        this.map = new ArrayList<>();
    }

    public void put(int key, int value) {
        for (int[] entry : map) {
            if (entry[0] == key) {
                entry[1] = value;
                return;
            }
        }

        map.add(new int[]{key, value});
    }

    public int get(int key) {
        for (int[] entry : map) {
            if (entry[0] == key) {
                return entry[1];
            }
        }

        return -1;
    }

    public void remove(int key) {
        for (int[] entry : map) {
            if (entry[0] == key) {
                map.remove(entry);
                return;
            }
        }
    }
}
