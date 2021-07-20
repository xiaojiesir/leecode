package array;


/**
 * 53. 最大子序和
 */
public class MaxSubArray {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            //num  > 0，则说明 num 对结果有增益效果，则 sum 加上当前遍历数字
            //num <= 0，则说明 num 对结果无增益效果，sum 直接更新为当前遍历数字
            sum = Math.max(sum + num, num);
            result = Math.max(result, sum);
        }
        return result;
    }


    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    /**
     * 分治
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }


    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
