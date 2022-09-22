package env.runtime;

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