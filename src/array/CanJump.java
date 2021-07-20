package array;

public class CanJump {
    public boolean canJump(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLength) {
                return false;
            }
            maxLength = Math.max(maxLength, nums[i] + i);

            if (maxLength >= nums.length - 1)
                return true;
        }
        return false;
    }
}
