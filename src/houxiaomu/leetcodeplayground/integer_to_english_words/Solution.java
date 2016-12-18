package houxiaomu.leetcodeplayground.integer_to_english_words;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/13.
 */
public class Solution extends BaseSolution {
    static final String[] SMALL_NUMS = new String[]{
            "Zero",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
    };

    static final String[] TEN_NUMS = new String[]{
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety",
    };

    static final String HUNDRED = "Hundred";
    static final String THOUSAND = "Thousand";
    static final String MILLION = "Million";
    static final String BILLION = "Billion";

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "Zero";
        if (num >= 1000000000) {
            helper(num / 1000000000, sb);
            sb.append(" ").append(BILLION);
            num %= 1000000000;
        }
        if (num >= 1000000) {
            helper(num / 1000000, sb);
            sb.append(" ").append(MILLION);
            num %= 1000000;
        }
        if (num >= 1000) {
            helper(num / 1000, sb);
            sb.append(" ").append(THOUSAND);
            num %= 1000;
        }
        helper(num, sb);
        return sb.toString();
    }

    void helper(int n, StringBuilder sb) {
        if (n >= 100) {
            sb.append(sb.length() == 0 ? "" : " ");
            sb.append(SMALL_NUMS[n / 100]).append(" ").append(HUNDRED);
            n %= 100;
        }
        if (n == 0) {
        } else if (n <= 19) {
            sb.append(sb.length() == 0 ? "" : " ");
            sb.append(SMALL_NUMS[n]);
        } else {
            sb.append(sb.length() == 0 ? "" : " ");
            sb.append(TEN_NUMS[n / 10]);
            n %= 10;
            if (n != 0) {
                sb.append(" ").append(SMALL_NUMS[n]);
            }
        }
    }
}
