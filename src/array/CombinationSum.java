package array;

import java.util.*;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> list = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(candidates);
        combination(candidates, 0, target, lists, list);
        return lists;
    }

    public void combination(int[] candidates, int begin, int target, List<List<Integer>> lists, Deque<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            //剪枝处理
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            //可以重复使用i不需要加1
            combination(candidates, i, target - candidates[i], lists, list);
            list.removeLast();
        }

    }
}
