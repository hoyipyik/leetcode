import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
 * 1312
 * 
 * 1980
 * 
 * Add to List
 * 
 * Share
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

class OldSolution {
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

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        var ans = new ArrayList<Integer>();
        int n = nums.length;
        int[] dict = new int[n];
        for(int i = 0; i < n; i ++){
            dict[nums[i] - 1] ++;
        }
        
        for(int i = 0; i < n; i ++){
            if(dict[i] > 1) ans.add(i + 1);
            
        }
        return ans;
    }
}

/**
 * Runtime: 8 ms, faster than 83.33% of Java online submissions for Find All
 * Duplicates in an Array.
 * Memory Usage: 68.1 MB, less than 28.16% of Java online submissions for Find
 * All Duplicates in an Array.
 */