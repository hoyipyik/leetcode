/**
 * 459. Repeated Substring Pattern
 * Easy
 * 
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 * 
 * Input: s = "aba"
 * Output: false
 * Example 3:
 * 
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc"
 * twice.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String holder;
        int len = s.length();
        int limit = (len % 2 == 0) ? len / 2 : len / 2 + 1;
        for (int i = 1; i <= limit; i++) {
            if (len % i != 0)
                continue;
            holder = s.substring(0, i);
            // System.out.println("sub length: " + i + " sub string: " + holder);
            for (int j = i; j <= len - i; j = j + i) {
                // System.out.println("Sub str: " + s.subSequence(j, j + i));
                if (!holder.equals(s.subSequence(j, j + i))) {
                    // System.out.println("Break factor: " + s.subSequence(j, j + i));
                    break;
                } else {
                    if (j == len - i) {
                        // System.out.println("True factor: " + s.subSequence(j, j + i));
                        return true;
                    }
                }

            }
        }
        return false;
    }
}

/**
 * Runtime: 13 ms, faster than 90.63% of Java online submissions for Repeated
 * Substring Pattern.
 * Memory Usage: 54.2 MB, less than 42.48% of Java online submissions for
 * Repeated Substring Pattern.
 */