package string;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        int i = 0, j = 0;
        while (i < slength && j < tlength) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;

            }
            j++;


        }
        return i == slength;
    }


    /**
     * 动态规划
     *
     *  防止因为大量输入的 S，如S1, S2, ... , Sk 其中 k >= 10亿，而需要依次检查它们是否为 T 的子序列。
     *  状态转移方程 :f[i][j] = i,      t[i] = j
     *                       =f[i+1,j] t[i]!=j
     *  ahbgdc
     *                      a b c d e f g h ... z
     *                  0 a 0 2 5 4 6 6 3 1 ... 6
     *                  1 h 6 2 5 4 6 6 3 1 ... 6
     *                  2 b 6 2 5 4 6 6 3 6 ... 6
     *                  3 g 6 6 5 4 6 6 3 6 ... 6
     *                  4 d 6 6 5 4 6 6 6 6 ... 6
     *                  5 c 6 6 5 6 6 6 6 6 ... 6
     *                  6   6 6 6 6 6 6 6 6 ... 6
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence1("abc", "ahbgdc"));
    }
}
