
/**
 * 229. Majority Element II
 * Medium
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 * 
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 * 
 * Input: nums = [1,2]
 * Output: [1,2]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * 
 * 
 * Follow up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class OldSolution {
    public List<Integer> majorityElement(int[] nums) {
        var ans = new ArrayList<Integer>();
        var map = new HashMap<Integer, Integer>();
        var addedMap = new HashMap<Integer, Boolean>();
        int threashold = nums.length / 3;
        for (int i : nums) {
            addedMap.putIfAbsent(i, false);
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
            int curn = map.get(i);
            if (curn > threashold && !addedMap.get(i)) {
                ans.add(i);
                addedMap.put(i, true);
            }
        }
        return ans;
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        var ans = new ArrayList<Integer>();
        var map = new HashMap<Integer, Integer>();
        int threshold = nums.length / 3;
        for(int i = 0; i < nums.length; i ++){
            int holder = map.getOrDefault(nums[i], 0);
            if(holder == -1) continue;
            map.put(nums[i], holder + 1);
            if(holder + 1 > threshold){
                ans.add(nums[i]);
                map.put(nums[i], -1);
            }
        }
        return ans;
    }
}

/**
 * Runtime: 12 ms, faster than 40.34% of Java online submissions for Majority
 * Element II.
 * Memory Usage: 50.6 MB, less than 33.07% of Java online submissions for
 * Majority Element II.
 */