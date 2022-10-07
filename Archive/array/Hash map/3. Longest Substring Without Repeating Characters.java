/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * 
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dict = new int[128];
        int slow = 0;
        int ans = 0;
        int cnt = 1;
        dict[s.charAt(slow)]++;
        for (int fast = 1; fast < s.length(); fast++) {
            while (fast + 1 < s.length() && s.charAt(fast) == s.charAt(fast - 1)) {
                slow = fast;
                dict = new int[128];
                cnt = 1;
                fast++;
                dict[s.charAt(slow)]++;
            }
            while (fast < s.length() && dict[s.charAt(fast)] > 0) {
                dict[s.charAt(slow)]--;
                slow++;
                cnt--;
            }

            cnt++;
            dict[s.charAt(fast)]++;
            ans = Math.max(ans, cnt);

        }
        ans = Math.max(cnt, ans);
        return ans;
    }
}

/**
 * Runtime: 7 ms, faster than 87.03% of Java online submissions for Longest
 * Substring Without Repeating Characters.
 * Memory Usage: 45 MB, less than 52.60% of Java online submissions for Longest
 * Substring Without Repeating Characters.
 */