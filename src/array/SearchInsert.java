package array;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
