/**
 * 209. Minimum Size Subarray Sum
 * Medium
 * 
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ...,
 * numsr-1, numsr] of which the sum is greater than or equal to target. If there
 * is no such subarray, return 0 instead.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * Example 2:
 * 
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */

class OldSolution {
    public int minSubArrayLen(int target, int[] nums) {
        int slowIndex = 0, fastIndex = 0;
        int len = nums.length;
        int size = 1;
        int ans = Integer.MAX_VALUE;
        int sum = nums[0];
        while (slowIndex < len && fastIndex < len && slowIndex <= fastIndex) {
            if (sum < target) {
                if (fastIndex != len - 1)
                    sum += nums[++fastIndex];
                else
                    break;
            } else {
                size = fastIndex - slowIndex + 1;
                ans = Math.min(ans, size);
                sum -= nums[slowIndex++];
            }
        }
        return ans = (ans == Integer.MAX_VALUE) ? 0 : ans;

    }
}

/**
 * 
 * Runtime: 4 ms, faster than 21.91% of Java online submissions for Minimum Size
 * Subarray Sum.
 * Memory Usage: 57.7 MB, less than 71.96% of Java online submissions for
 * Minimum Size Subarray Sum.
 */

// They are almost the same, but apparently the new one is easier to compose

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            sum += nums[fastIndex];
            while (sum >= target) {
                ans = Math.min(ans, fastIndex - slowIndex + 1);
                sum -= nums[slowIndex++];
            }
        }
        return ans = (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}

/**
 * Runtime: 2 ms, faster than 81.45% of Java online submissions for Minimum Size
 * Subarray Sum.
 * Memory Usage: 57.8 MB, less than 60.38% of Java online submissions for
 * Minimum Size Subarray Sum.
 */