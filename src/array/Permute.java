package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permute {
    //标志位 是否已使用
    boolean[] used;

    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        permute1(nums, new ArrayList<>(), lists);
        return lists;
    }

    public void permute1(int[] nums, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            permute1(nums, list, lists);
            used[i] = false;
            list.remove(list.size()-1);
        }

    }
}
