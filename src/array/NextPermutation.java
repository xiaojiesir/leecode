package array;

/**
 * 31. 下一个排列
 */
public class NextPermutation {
    /**
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从右开始寻找降序的第一个数字
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //从右寻找 第一个比较小数大的数字
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //进行交换
            swap(nums, i, j);
        }
        //将较小数后面的数字按照降序排序
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


}
