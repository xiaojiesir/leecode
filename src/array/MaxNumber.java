package array;

import java.util.Stack;

/**
 * 321. 拼接最大数
 * <p>
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 */
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int maxSum = 0;
        int[] result = new int[k];
        for (int i = 1; i < k; i++) {
            int[] result1 = maxNumber(nums1, i);
            int[] result2 = maxNumber(nums2, k - i);
            int[] result3 = new int[k];
            int sum = 0;
            int indexa = 0;
            int indexb = 0;
            int indexc = 0;
            while (indexa < i || indexb < k - i) {
                if (indexa < i) {
                    if (indexb < k - i) {
                        if (result1[indexa] < result2[indexb]) {
                            sum = sum * 10 + result2[indexb];
                            result3[indexc++] = result2[indexb++];
                        } else {
                            sum = sum * 10 + result1[indexa];
                            result3[indexc++] = result1[indexa++];
                        }


                    } else {
                        sum = sum * 10 + result1[indexa];
                        result3[indexc++] = result1[indexa++];
                    }

                } else {
                    sum = sum * 10 + result2[indexb];
                    result3[indexc++] = result2[indexb++];
                }

            }
            if(maxSum<sum){
                maxSum = sum;
                result = result3;
            }

        }
        return result;
    }

    public int[] maxNumber(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        int length = nums.length;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (k < length - i) {
                while (!stack.isEmpty() && stack.peek() < num) {
                    stack.pop();
                    k++;
                }
            }
            if (k > 0) {
                stack.push(num);
                i++;
                k--;
            }


        }
        int resLength = stack.size();
        int[] result = new int[resLength];
        for (int j = resLength - 1; j >= 0; j--) {
            result[j] = stack.pop();

        }
        return result;

    }

    public static void main(String[] args) {
        MaxNumber number = new MaxNumber();
        //int[] result1 = number.maxNumber(new int[]{9, 1, 2, 5, 8, 3}, 1);
        int[] result2 = number.maxNumber(new int[]{3, 4, 6, 5},new int[]{9, 1, 2, 5, 8, 3}, 5);

    }
}
