package num;

/**
 * 9. 回文数
 */
public class IsPalindrome {
    /**
     * 取出后半段数字进行翻转
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
