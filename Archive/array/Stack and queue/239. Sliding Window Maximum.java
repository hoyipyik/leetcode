import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 * Hard
 * 
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position Max
 * --------------- -----
 * [1 3 -1] -3 5 3 6 7 3
 * 1 [3 -1 -3] 5 3 6 7 3
 * 1 3 [-1 -3 5] 3 6 7 5
 * 1 3 -1 [-3 5 3] 6 7 5
 * 1 3 -1 -3 [5 3 6] 7 6
 * 1 3 -1 -3 5 [3 6 7] 7
 * Example 2:
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */

class MyQuene {
    Deque<Integer> queue = new LinkedList<>();

    public void poll(int out) {
        if (!queue.isEmpty() && out == queue.peek()) {
            queue.poll();
        }
    }

    public void add(int in) {
        while (!queue.isEmpty() && in > queue.getLast()) {
            queue.removeLast();
        }
        queue.add(in);
    }

    public int getMax() {
        return queue.peek();
    }

}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        var queue = new MyQuene();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        ans[j++] = queue.getMax();
        for (int l = k; l < nums.length; l++) {
            queue.add(nums[l]);
            queue.poll(nums[l - k]);
            ans[j++] = queue.getMax();
        }
        return ans;
    }
}

/**
 * Runtime: 48 ms, faster than 78.59% of Java online submissions for Sliding
 * Window Maximum.
 * Memory Usage: 58.3 MB, less than 97.64% of Java online submissions for
 * Sliding Window Maximum.
 */