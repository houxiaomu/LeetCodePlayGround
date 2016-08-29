package houxiaomu.leetcodeplayground.multiply_strings;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-8-29.
 */
public class Solution extends BaseSolution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        int d1 = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            char c1 = num1.charAt(i);
            int d2 = 0;
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                char c2 = num2.charAt(j);
                int r = (c2 - '0') * (c1 - '0') + carry;
                carry = r / 10;
                addDigit(result, d1 + d2, r % 10);
                d2++;
            }
            if (carry > 0) {
                addDigit(result, d1 + d2, carry);
            }
            d1++;
        }

        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (start) {
                sb.append(result[i]);
            } else if (result[i] != 0) {
                start = true;
                sb.append(result[i]);
            }
        }
        return start ? sb.toString() : "0";
    }

    private void addDigit(int[] result, int index, int number) {
        while (true) {
            result[index] += number;
            if (result[index] > 9) {
                result[index] = result[index] % 10;
                index++;
                number = 1;
            } else {
                break;
            }
        }
    }
}
