package houxiaomu.leetcodeplayground.valid_parentheses;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Stack;

/**
 * Created by houxiaomu on 16-7-26.
 */
public class Solution extends BaseSolution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        Character character;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.empty()) return false;
                character = stack.pop();
                if (character == null || !character.equals('[')) {
                    return false;
                }
            } else if (c == '}') {
                if (stack.empty()) return false;
                character = stack.pop();
                if (character == null || !character.equals('{')) {
                    return false;
                }
            } else if (c == ')') {
                if (stack.empty()) return false;
                character = stack.pop();
                if (character == null || !character.equals('(')) {
                    return false;
                }
            }
        }
        if (stack.size() > 0) return false;
        return true;
    }
}
