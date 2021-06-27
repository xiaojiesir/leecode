package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 解题思路:滑动窗口
 *
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
 *
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
 *
 * 时间复杂度：O(n)O(n)
 *
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int result = 0;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (j < length && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            result = Math.max(result, j - i);
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static void main(String[] args) {
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        System.out.println(length.lengthOfLongestSubstring2("abcabcbb"));
    }
}
