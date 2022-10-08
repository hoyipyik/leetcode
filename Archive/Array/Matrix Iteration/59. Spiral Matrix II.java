/**
 * 59. Spiral Matrix II
 * Medium
 * 
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 * 
 * Input: n = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 20
 */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int x = -1;
        int y = 0;
        int i = 1;
        while (i <= n * n) {
            while (x < n - 1 && ans[y][x + 1] == 0)
                ans[y][++x] = i++;
            while (y < n - 1 && ans[y + 1][x] == 0)
                ans[++y][x] = i++;
            while (x > 0 && ans[y][x - 1] == 0)
                ans[y][--x] = i++;
            while (y > 0 && ans[y - 1][x] == 0)
                ans[--y][x] = i++;
        }
        return ans;
    }
}
/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral
 * Matrix II.
 * Memory Usage: 41.9 MB, less than 60.99% of Java online submissions for Spiral
 * Matrix II.
 */