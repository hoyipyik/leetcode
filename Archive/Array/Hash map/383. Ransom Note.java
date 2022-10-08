import java.util.HashMap;

/**
 * 383. Ransom Note
 * Easy
 * 
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * 
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * 
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */

class OldSolution {
    public boolean canConstruct(String ransomNote, String magazine) {
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (map.get(ch) == null || map.get(ch) <= 0)
                return false;
            else
                map.put(ch, map.get(ch) - 1);
        }
        return true;
    }
}

class SlowerSolution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            dict[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            dict[ransomNote.charAt(i) - 'a']--;
            if (dict[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        for (char i : magazine.toCharArray()) {
            dict[i - 'a']++;
        }
        for (int i : ransomNote.toCharArray()) {
            dict[i - 'a']--;
            if (dict[i - 'a'] < 0)
                return false;
        }
        return true;
    }
}

/**
 * Runtime: 3 ms, faster than 91.20% of Java online submissions for Ransom Note.
 * Memory Usage: 46.6 MB, less than 47.95% of Java online submissions for Ransom
 * Note.
 */