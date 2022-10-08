/**
 * 242. Valid Anagram
 * Easy
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt
 * your solution to such a case?
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
            dict[t.charAt(i) - 'a']--;
        }
        for (int i : dict) {
            if (i != 0)
                return false;
        }
        return true;

    }
}

/**
 * Runtime: 6 ms, faster than 64.07% of Java online submissions for Valid
 * Anagram.
 * Memory Usage: 43.7 MB, less than 62.51% of Java online submissions for Valid
 * Anagram.
 * 
 */