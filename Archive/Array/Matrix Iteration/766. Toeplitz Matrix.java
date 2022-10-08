
/**
 * 766. Toeplitz Matrix
 * Easy
 * 
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise,
 * return false.
 * 
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same elements.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: true
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,2],[2,2]]
 * Output: false
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 * 
 * 
 * Follow up:
 * 
 * What if the matrix is stored on disk, and the memory is limited such that you
 * can only load at most one row of the matrix into the memory at once?
 * What if the matrix is so large that you can only load up a partial row into
 * the memory at once?
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean ans = true;
        int rown = matrix.length;
        int coln = matrix[0].length;
        int i = 0, j = rown - 1;
        int looper = rown - 1;
        int former = matrix[i][j];
        while (looper-- > 0) {
            while (j < rown && i < coln) {
                if (i == 0)
                    former = matrix[j][i];
                if (matrix[j][i] != former)
                    return false;
                i++;
                j++;
            }
            i = 0;
            j = looper;
        }
        looper = 0;
        j = 0;
        i = 0;
        while (looper++ < coln - 1) {
            // System.out.println("Loop: " + looper);
            while (i < coln && j < rown) {
                // System.out.println("i: " + i + " j: " + j);
                if (j == 0)
                    former = matrix[j][i];
                if (matrix[j][i] != former)
                    return false;
                i++;
                j++;
            }
            j = 0;
            i = looper;
        }
        return ans;

    }
}

/**
 * Runtime: 1 ms, faster than 94.28% of Java online submissions for Toeplitz
 * Matrix.
 * Memory Usage: 42.4 MB, less than 90.24% of Java online submissions for
 * Toeplitz Matrix.
 */