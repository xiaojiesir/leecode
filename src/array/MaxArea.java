package array;

/**
 * 11. 盛最多水的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        while (i < j) {
            result = height[i] < height[j] ?
                    Math.max(result, (j - i) * height[i++]) :
                    Math.max(result, (j - i) * height[j--]);


        }
        return result;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
