package num;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. 完全平方数
 */
public class NumSquares {
    /**
     * BFS
     * 我们可以一层一层的算。第一层依次减去一个平方数得到第二层，第二层依次减去一个平方数得到第三层。直到某一层出现了 0，此时的层数就是我们要找到平方数和的最小个数。
     *
     * 举个例子，n = 12，每层的话每个节点依次减 1, 4, 9...。
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++; // 开始生成下一层
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                //依次减 1, 4, 9... 生成下一层的节点
                for (int j = 1; j * j <= cur; j++) {
                    int next = cur - j * j;
                    if (next == 0) {
                        return level;
                    }
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }


    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numSquares1(int n) {
        int dp[] = new int[n + 1];
        //依次求出 1, 2... 直到 n 的解
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每次+1
            dp[i] = i;
            //依次减去一个平方数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 四平方和定理，意思是任何正整数都能表示成四个平方数的和。少于四个平方数的，像 12 这种，可以补一个 0 也可以看成四个平方数，12 = 4 + 4 + 4 + 0。知道了这个定理，对于题目要找的解，其实只可能是 1, 2, 3, 4 其中某个数。
     *
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        //判断是否是 1
        if (isSquare(n)) {
            return 1;
        }

        //判断是否是 4
        int temp = n;
        while (temp % 4 == 0) {
            temp /= 4;
        }
        if (temp % 8 == 7) {
            return 4;
        }

        //判断是否是 2
        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    //判断是否是平方数
    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }


    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(12));
        System.out.println(numSquares.numSquares1(12));
        System.out.println(numSquares.numSquares2(12));
    }
}
