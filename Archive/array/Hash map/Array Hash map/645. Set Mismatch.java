import java.util.HashMap;

/**
 * 645. Set Mismatch
 * Easy
 * 
 * You have a set of integers s, which originally contains all the numbers from
 * 1 to n. Unfortunately, due to some error, one of the numbers in s got
 * duplicated to another number in the set, which results in repetition of one
 * number and loss of another number.
 * 
 * You are given an integer array nums representing the data status of this set
 * after the error.
 * 
 * Find the number that occurs twice and the number that is missing and return
 * them in the form of an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 * 
 * Input: nums = [1,1]
 * Output: [1,2]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 * 
 */

class OldSolution {
    public int[] findErrorNums(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2)
                    a = i;
            } else
                b = i;
        }
        int[] ans = new int[] { a, b };
        return ans;
    }
}

class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicated = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur - 1] < 0) {
                duplicated = cur;
            } else
                nums[cur - 1] = -nums[cur - 1];
        }
        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] > 0)
                return new int[] { duplicated, i + 1 };
        }
        return null;
    }
}

/**
 * Runtime: 4 ms, faster than 63.87% of Java online submissions for Set
 * Mismatch.
 * Memory Usage: 54.9 MB, less than 31.46% of Java online submissions for Set
 * Mismatch.
 */
