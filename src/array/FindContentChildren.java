package array;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class FindContentChildren {
    /**
     * 贪心算法
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int glength = g.length;
        int slength = s.length;
        for (int i = 0, j = 0; i < glength && j < slength; i++, j++) {
            while (j < slength && g[i] > s[j]) {
                j++;
            }
            if (j < slength) {
                result++;
            }

        }
        return result;
    }
}
