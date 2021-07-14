package array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int small = searchSmall(nums, target, length);
        int large = searchLarge(nums, target, length);
        if (small > large) {
            return new int[]{-1, -1};
        }
        return new int[]{small, large};
    }

    /**
     * 搜索第一次出现的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchSmall(int[] nums, int target, int length) {
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;

    }

    /**
     * 搜索第一个比指定数字大的下标
     * @param nums
     * @param target
     * @param length
     * @return
     */
    public int searchLarge(int[] nums, int target, int length) {
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;

    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
