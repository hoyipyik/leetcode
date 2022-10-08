/**
 * 541. Reverse String II
 * Easy
 * 
 * Given a string s and an integer k, reverse the first k characters for every
 * 2k characters counting from the start of the string.
 * 
 * If there are fewer than k characters left, reverse all of them. If there are
 * less than 2k but greater than or equal to k characters, then reverse the
 * first k characters and leave the other as original.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 * 
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 104
 */

class Solution {
    public char[] reverseString(char[] str, int start, int end) {
        int left = start;
        int right = end - 1;
        while (left < right) {
            char holder = str[right];
            str[right] = str[left];
            str[left] = holder;
            right--;
            left++;
        }
        return str;
    }

    public String reverseStr(String s, int k) {
        char[] ans = s.toCharArray();
        for (int i = 0; i < ans.length; i += 2 * k) {
            if (i + k <= ans.length)
                ans = reverseString(ans, i, i + k);
            else
                ans = reverseString(ans, i, ans.length);
        }
        return new String(ans);
    }
}

/**
 * Runtime: 2 ms, faster than 78.75% of Java online submissions for Reverse
 * String II.
 * Memory Usage: 44.3 MB, less than 27.41% of Java online submissions for
 * Reverse String II.
 */