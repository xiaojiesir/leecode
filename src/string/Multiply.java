package string;

/**
 * 43. 字符串相乘
 */
public class Multiply {
    /**
     *              1|2|3
     *              4|5|6
     *                1|8
     *              1|2|
     *            0|6| |
     *              1|5|
     *            1|0| |
     *          0|5| | |
     *            1|2| |
     *          0|8| | |
     *        0|4| | | |
     *          5 6 0 8 8
     *
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] result = new int[a + b + 2];
        for (int i = a; i >= 0; i--) {
            for (int j = b; j >= 0; j--) {
                int sum = result[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;


            }

        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) continue;
            builder.append(result[i]);

        }
        return builder.toString();
    }
}
