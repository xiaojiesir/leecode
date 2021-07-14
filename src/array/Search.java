package array;

/**
 * 33. 搜索旋转排序数组
 */
public class Search {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        //二分查找
        while (start <= end) {
            //不用加 防止越界
            int mid = ((end - start) >> 1) + start;
            if (nums[mid] == target)
                return mid;
            //有序部分
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{5, 1, 3}, 3));
    }
}
