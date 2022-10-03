import java.util.LinkedList;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * Easy
 * 
 * You are given a string s consisting of lowercase English letters. A duplicate
 * removal consists of choosing two adjacent and equal letters and removing
 * them.
 * 
 * We repeatedly make duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * can be proven that the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent
 * and equal, and this is the only possible move. The result of this move is
 * that the string is "aaca", of which only "aa" is possible, so the final
 * string is "ca".
 * Example 2:
 * 
 * Input: s = "azxxzy"
 * Output: "ay"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */

class Solution {
    public String removeDuplicates(String s) {
        var stack = new LinkedList<Character>();
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() != 0 && stack.getLast() == s.charAt(i))
                stack.removeLast();
            else
                stack.add(s.charAt(i));
        }
        var builder = new StringBuilder();
        for (Character character : stack) {
            builder.append(character);
        }
        return builder.toString();
    }
}

/**
 * Runtime: 47 ms, faster than 67.25% of Java online submissions for Remove All
 * Adjacent Duplicates In String.
 * Memory Usage: 60.1 MB, less than 24.86% of Java online submissions for Remove
 * All Adjacent Duplicates In String.
 * Notice: Time consumption focus on the build of the new string
 */