package string;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {

    /**
     * 中心扩散法
     * 「中心扩散法」的基本思想是：遍历每一个下标，以这个下标为中心，利用「回文串」中心对称的特点，往两边扩散，看最多能扩散多远。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        String result = null;
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            int[] begin = center(s, i, i);
            int[] end = center(s, i, i + 1);
            int beginLength = begin[1] - begin[0];
            int endLength = end[1] - end[0];
            if (endLength > beginLength) {
                if (endLength > maxLength) {
                    maxLength = endLength;
                    result = s.substring(end[0], end[1]);
                }

            } else {
                if (beginLength > maxLength) {
                    maxLength = beginLength;
                    result = s.substring(begin[0], begin[1]);
                }
            }

        }
        return result;
    }

    public int[] center(String s, int left, int right) {
        int length = s.length();
        while (left >= 0 && right < length) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }

        }
        return new int[]{left + 1, right};
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        // 特殊用例判断
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
    }
}
