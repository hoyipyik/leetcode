/**
 * 344. Reverse String
 * Easy
 * 
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * 
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char holder = s[right];
            s[right] = s[left];
            s[left] = holder;
            right--;
            left++;
        }
        return;
    }
}

/**
 * Runtime: 1 ms, faster than 99.90% of Java online submissions for Reverse
 * String.
 * Memory Usage: 58.1 MB, less than 11.33% of Java online submissions for
 * Reverse String.
 * 
 */