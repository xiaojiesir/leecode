package array;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            //不能重复使用,所以 遍历时若出现之前已经选择过的数字跳过,
            // 不加i != begin 会导致递归的时候 也不能选择相同数字
            //例子中 [1,1,6] 是允许的, 不加i != begin ,就会不允许
            if (i != begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            //不能重复使用i必须加1
            combination(candidates, i + 1, target - candidates[i], lists, list);
            list.removeLast();
        }

    }
}
