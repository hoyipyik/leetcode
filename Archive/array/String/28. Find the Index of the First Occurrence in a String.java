/**
 * 28. Find the Index of the First Occurrence in a String
 * Medium
 * 
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * 
 * Example 1:
 * 
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * 
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */

class Solution {
    public void getNext(String str, int[] next) {
        int i = 1;
        int j = 0;
        for (i = 1; i < next.length; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = next[j - 1];
            if (str.charAt(i) == str.charAt(j))
                j++;
            next[i] = j;
        }
    }

    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] next = new int[needle.length()];
        getNext(needle, next);
        for (i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j))
                j++;
            if (j == needle.length())
                return (i - needle.length() + 1);
        }
        return -1;
    }
}

/**
 * Runtime: 1 ms, faster than 66.34% of Java online submissions for Find the
 * Index of the First Occurrence in a String.
 * Memory Usage: 41.6 MB, less than 75.73% of Java online submissions for Find
 * the Index of the First Occurrence in a String.
 * 
 */