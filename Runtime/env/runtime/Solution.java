/**
 * 442. Find All Duplicates in an Array
 * Medium
 * 
 * Given an integer array nums of length n where all the integers of nums are in
 * the range [1, n] and each integer appears once or twice, return an array of
 * all the integers that appears twice.
 * 
 * You must write an algorithm that runs in O(n) time and uses only constant
 * extra space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * Example 2:
 * 
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 * 
 * Input: nums = [1]
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Each element in nums appears once or twice.
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        var map = new HashMap<Integer, Integer>(len);
        var ans = new ArrayList<Integer>(len);
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i <= len; i++) {
            if (map.containsKey(i))
                if (map.get(i) == 2)
                    ans.add(i);
        }
        return ans;
    }
}

/**
 * Runtime: 60 ms, faster than 5.13% of Java online submissions for Find All
 * Duplicates in an Array.
 * Memory Usage: 71.5 MB, less than 8.02% of Java online submissions for Find
 * All Duplicates in an Array.
 * 
 */