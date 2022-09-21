class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int cnt = 0;
        int fast = 0;
        for (int slow = 0; slow < len && fast < len; slow++) {
            if (nums[slow] == val) {
                fast ++;
                nums[slow] = nums[fast];
            }
            fast ++;
        }
        return len - cnt;
    }
}