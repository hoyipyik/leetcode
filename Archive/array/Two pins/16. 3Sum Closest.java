
import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Medium
 * 
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * 
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3)
            return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int gap = Math.abs(nums[len - 1] + nums[0] + nums[1] - target);
        int ans = nums[0] + nums[1] + nums[2];
        int j, k;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            j = i + 1;
            k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int curGap = Math.abs(target - sum);
                if (sum == target)
                    return target;
                else {
                    if (curGap < gap) {
                        gap = curGap;
                        ans = sum;
                    }
                    if (sum < target)
                        j++;
                    else
                        k--;
                }
            }

        }

        return ans;

    }
}

/**
 * Runtime: 79 ms, faster than 71.09% of Java online submissions for 3Sum
 * Closest.
 * Memory Usage: 48.7 MB, less than 57.28% of Java online submissions for 3Sum
 * Closest.
 * 
 */
