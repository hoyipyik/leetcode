import java.util.HashMap;

/**
 * 
 * 
 * Easy
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * 
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 * 
 * 
 * Constraints:
 * 
 * nums.length will be between 1 and 50,000.
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        int ans = nums.length;
        var cntMap = new HashMap<Integer, Integer>();
        var leftMap = new HashMap<Integer, Integer>();
        var rightMap = new HashMap<Integer, Integer>();
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            cntMap.put(cur, cntMap.getOrDefault(cur, 0) + 1);
            if (leftMap.get(cur) == null)
                leftMap.put(cur, i);
            rightMap.put(cur, i);
            times = Math.max(cntMap.get(cur), times);
        }

        for (var entry : cntMap.entrySet()) {
            if (entry.getValue() == times) {
                int key = entry.getKey();
                int len = rightMap.get(key) - leftMap.get(key) + 1;
                ans = Math.min(ans, len);
            }
        }

        return ans;
    }
}

/**
 * Runtime: 54 ms, faster than 25.75% of Java online submissions for Degree of
 * an Array.
 * Memory Usage: 53 MB, less than 84.97% of Java online submissions for Degree
 * of an Array.
 */