import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 * Easy
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * Output: true
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

class Solution {
    public boolean isValid(String s) {
        var stack = new LinkedList<Character>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if (stack.size() == 0) {
                return false;
            } else {
                if (ch == ')' && stack.pop() != '(')
                    return false;
                if (ch == ']' && stack.pop() != '[')
                    return false;
                if (ch == '}' && stack.pop() != '{')
                    return false;
            }
        }
        return stack.size() == 0;
    }
}

/**
 * Runtime: 4 ms, faster than 41.61% of Java online submissions for Valid
 * Parentheses.
 * Memory Usage: 42.4 MB, less than 22.40% of Java online submissions for Valid
 * Parentheses.
 * 
 */