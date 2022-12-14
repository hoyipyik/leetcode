/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * Medium
 *
 * Given an n x n matrix where each of the rows and columns is sorted in
 * ascending order, return the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * You must find a solution with a memory complexity better than O(n2).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and
 * the 8th smallest number is 13
 * Example 2:
 * 
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 * 
 * 
 * Constraints:
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * All the rows and columns of matrix are guaranteed to be sorted in
 * non-decreasing order.
 * 1 <= k <= n2
 * 
 * 
 * Follow up:
 * 
 * Could you solve the problem with a constant memory (i.e., O(1) memory
 * complexity)?
 * Could you solve the problem in O(n) time complexity? The solution may be too
 * advanced for an interview but you may find reading this paper fun.
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}

/**
 * Runtime: 7 ms, faster than 66.21% of Java online submissions for Kth Smallest
 * Element in a Sorted Matrix.
 * Memory Usage: 56.9 MB, less than 51.32% of Java online submissions for Kth
 * Smallest Element in a Sorted Matrix.
 */