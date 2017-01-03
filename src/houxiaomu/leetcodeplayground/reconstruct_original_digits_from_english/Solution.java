package houxiaomu.leetcodeplayground.reconstruct_original_digits_from_english;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/26.
 */
public class Solution extends BaseSolution {
    static final char[][] NUMBERS = {"zero".toCharArray(), "one".toCharArray(),
            "two".toCharArray(), "three".toCharArray(), "four".toCharArray(),
            "five".toCharArray(), "six".toCharArray(), "seven".toCharArray(),
            "eight".toCharArray(), "nine".toCharArray()};

    public String originalDigits(String s) {
        int[] letters = new int[26];
        int n0 = 0, n2 = 0, n4 = 0, n6 = 0, n8 = 0;
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
            if (c == 'z') {
                n0++;
            } else if (c == 'w') {
                n2++;
            } else if (c == 'u') {
                n4++;
            } else if (c == 'x') {
                n6++;
            } else if (c == 'g') {
                n8++;
            }
        }

        for (char c : NUMBERS[0]) {
            letters[c - 'a'] -= n0;
        }
        for (char c : NUMBERS[2]) {
            letters[c - 'a'] -= n2;
        }
        for (char c : NUMBERS[4]) {
            letters[c - 'a'] -= n4;
        }
        for (char c : NUMBERS[6]) {
            letters[c - 'a'] -= n6;
        }
        for (char c : NUMBERS[8]) {
            letters[c - 'a'] -= n8;
        }

        int n3 = letters['t' - 'a'];
        int n5 = letters['f' - 'a'];
        int n7 = letters['s' - 'a'];
        for (char c : NUMBERS[3]) {
            letters[c - 'a'] -= n3;
        }
        for (char c : NUMBERS[5]) {
            letters[c - 'a'] -= n5;
        }
        for (char c : NUMBERS[7]) {
            letters[c - 'a'] -= n7;
        }

        int n1 = letters['o' - 'a'];
        int n9 = letters['i' - 'a'];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n0; i++) sb.append('0');
        for (int i = 0; i < n1; i++) sb.append('1');
        for (int i = 0; i < n2; i++) sb.append('2');
        for (int i = 0; i < n3; i++) sb.append('3');
        for (int i = 0; i < n4; i++) sb.append('4');
        for (int i = 0; i < n5; i++) sb.append('5');
        for (int i = 0; i < n6; i++) sb.append('6');
        for (int i = 0; i < n7; i++) sb.append('7');
        for (int i = 0; i < n8; i++) sb.append('8');
        for (int i = 0; i < n9; i++) sb.append('9');
        return sb.toString();
    }

//    public String originalDigits(String s) {
//        int[] letters = new int[26];
//        for (char c : s.toCharArray()) {
//            letters[c - 'a']++;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        helper(sb, 0, letters);
//        return sb.toString();
//    }
//
//    boolean helper(StringBuilder sb, int number, int[] letters) {
//        if (number == 10) {
//            for (int n : letters) {
//                if (n != 0) return false;
//            }
//            return true;
//        }
//
//        int count = 0;
//        char[] chars = NUMBERS[number];
//        while (true) {
//            boolean take = true;
//            for (char c : chars) {
//                letters[c - 'a']--;
//                if (letters[c - 'a'] < 0) take = false;
//            }
//
//            if (!take) {
//                for (char c : chars) {
//                    letters[c - 'a']++;
//                }
//                break;
//            } else {
//                sb.append(number);
//                count++;
//            }
//        }
//
//        while (count >= 0) {
//            if (helper(sb, number + 1, letters)) return true;
//            count--;
//            if (count >= 0) {
//                char lastNumber = sb.charAt(sb.length() - 1);
//                for (char c : NUMBERS[lastNumber - '0']) {
//                    letters[c - 'a']++;
//                }
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//        return false;
//    }
}
