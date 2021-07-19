package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //进行排序,才能去重
        Arrays.sort(nums);
        int[] visit = new int[nums.length];
        permuteUnique1(nums, lists, list, visit);
        return lists;
    }

    public void permuteUnique1(int[] nums, List<List<Integer>> lists, List<Integer> list, int[] visit) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1)
                continue;
            //visit[i - 1] == 1  也是可以的
            //如果要对树层中前一位去重，visit[i - 1] == 0，如果要对树枝前一位去重用visit[i - 1] == 1
            //对于排列问题，树层上去重和树枝上去重，都是可以的，但是树层上去重效率更高！ 所以优先树层去重
            if (i != 0 && nums[i] == nums[i - 1] && visit[i - 1] == 0)
                continue;

            visit[i] = 1;
            list.add(nums[i]);
            permuteUnique1(nums, lists, list, visit);
            visit[i] = 0;
            list.remove(list.size() - 1);

        }

    }
}
