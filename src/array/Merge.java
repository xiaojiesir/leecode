package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        int[][] result = new int[length][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else
                    return 0;
            }
        });
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > result[idx][1]) {
                result[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                result[idx][1] = Math.max(result[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, idx + 1);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] result =  merge.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}
