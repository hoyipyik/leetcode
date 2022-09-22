
/**
 * 2404. Most Frequent Even Element
Easy

Given an integer array nums, return the most frequent even element.

If there is a tie, return the smallest one. If there is no such element, return -1.

 

Example 1:

Input: nums = [0,1,2,2,4,4,1]
Output: 2
Explanation:
The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
We return the smallest one, which is 2.
Example 2:

Input: nums = [4,4,4,9,2,4]
Output: 4
Explanation: 4 is the even element appears the most.
Example 3:

Input: nums = [29,47,21,41,13,37,25,7]
Output: -1
Explanation: There is no even element.
 

Constraints:

1 <= nums.length <= 2000
0 <= nums[i] <= 105
 */

import java.util.HashMap;

class Solution {
    public int mostFrequentEven(int[] nums) {
        int result = -1;
        int best = 0;
        final var map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (i % 2 == 0) {
                map.computeIfAbsent(i, e -> 1);
                map.computeIfPresent(i, (k, v) -> v + 1);
                int cur = map.get(i);
                if (cur > best) {
                    best = cur;
                    result = i;
                } else if (cur == best && i < result) {
                    result = i;
                }
            }
        }

        return result;
    }
}

/**
 * Runtime: 40 ms, faster than 69.71% of Java online submissions for Most
 * Frequent Even Element.
 * Memory Usage: 59.9 MB, less than 53.52% of Java online submissions for Most
 * Frequent Even Element.
 */