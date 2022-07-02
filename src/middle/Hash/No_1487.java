package middle.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1487 保证文件名唯一 (Microsoft)
 */
public class No_1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int n = names.length;
        String[] ans = new String[n];
        int i = 0;

        for (String name : names) {
            if (map.containsKey(name)) {
                int num = map.get(name);
                String str = name + '(' + num + ')';
                while (map.containsKey(str)) {
                    num ++;
                    str = name + '(' + num + ')';
                }

                ans[i ++] = str;
                map.put(str, 1);
            } else {
                ans[i ++] = name;
            }

            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        return ans;
    }
}
