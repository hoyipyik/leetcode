import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Easy
 * 
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in
 * nums.
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * 
 * Input: nums = [1,1]
 * Output: [2]
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 
 * 
 * Follow up: Could you do it without extra space and in O(n) runtime? You may
 * assume the returned list does not count as extra space.
 */

class SolutionOld {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(i, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i))
                ans.add(i);
        }

        return ans;
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        var ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                ans.add(i + 1);
        }
        return ans;
    }
}

/**
 * Runtime: 5 ms, faster than 97.74% of Java online submissions for Find All
 * Numbers Disappeared in an Array.
 * Memory Usage: 50.1 MB, less than 97.93% of Java online submissions for Find
 * All Numbers Disappeared in an Array.
 */
