package array;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
    //动态规划
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }



    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        maxProduct.maxProduct(new int[]{2, 3, -2, 4});
    }
}
