package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 */
public class GroupAnagrams {
    /**
     * 计数,计算每个字母出现的次数
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] num = new int[26];
            //记录每个字符的次数
            for (int j = 0; j < strs[i].length(); j++) {
                num[strs[i].charAt(j) - 'a']++;
            }
            //转成 0#2#2# 类似的形式
            String key = "";
            for (int j = 0; j < num.length; j++) {
                key = key + num[j] + '#';
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());


    }


    /**
     * 先对每个字符串进行字母排序,在比较
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());

    }

}
