package middle.greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * No.406 根据身高重建队列
 */
public class No_406 {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 1) {
            return people;
        }

        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][]);
    }
}
