class Solution {
    public int removeDuplicates(int[] nums) {
        int slowIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[slowIndex++] = nums[i];
        }
        return slowIndex;
    }
}

/**
 * Runtime: 2 ms, faster than 50.08% of Java online submissions for Remove
 * Duplicates from Sorted Array.
 * Memory Usage: 47.7 MB, less than 57.14% of Java online submissions for Remove
 * Duplicates from Sorted Array.
 */