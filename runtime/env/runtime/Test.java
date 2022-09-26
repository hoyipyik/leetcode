class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = nums[0];
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast ++){
            int size = fast - slow + 1;
            if(sum >= target){
                sum -= nums[slow++];
                fast --;
                ans = Math.min(ans, size);
            }
        }
        return ans;
    }
}