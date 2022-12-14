
/**
 * 15. 3Sum
 * Medium
 * 
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * Example 2:
 * 
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * 
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * 
 * 
 * Constraints:
 * 
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var ans = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3)
            return List.of();
        Arrays.sort(nums);
        int j, k;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            j = i + 1;
            k = len - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }

        }

        return ans;

    }
}

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        var ans = new ArrayList<List<Integer>>();
        if(nums.length < 3) return null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i -1]) continue;
            int j = i + 1; int k = nums.length -1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) k --;
                else if(sum < 0) j ++;
                else{
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                    j++; k --;
                }
            }
        }
        return ans;
    }
}

/**
 * Runtime: 26 ms, faster than 88.20% of Java online submissions for 3Sum.
 * Memory Usage: 46.2 MB, less than 97.10% of Java online submissions for 3Sum.
 */
