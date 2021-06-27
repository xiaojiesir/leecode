package num;

/**
 * 12. 整数转罗马数字
 */
public class IntToRoman {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < romans.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                builder.append(romans[i]);
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(1994));
    }
}
