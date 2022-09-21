/**
 * 667. Beautiful Arrangement II
 * Medium
 *
 * Given two integers n and k, construct a list answer that contains n different
 * positive integers ranging from 1 to n and obeys the following requirement:
 * 
 * Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 -
 * a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct
 * integers.
 * Return the list answer. If there multiple valid answers, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3, k = 1
 * Output: [1,2,3]
 * Explanation: The [1,2,3] has three different positive integers ranging from 1
 * to 3, and the [1,1] has exactly 1 distinct integer: 1
 * Example 2:
 * 
 * Input: n = 3, k = 2
 * Output: [1,3,2]
 * Explanation: The [1,3,2] has three different positive integers ranging from 1
 * to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
 * 
 * 
 * Constraints:
 * 
 * 1 <= k < n <= 104
 */

class SolutionOld {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int i = 1;
        int j = n;
        for (int p = 0; p < n; p++) {
            if (p < k - 1) {
                if (k % 2 == 0 ? p % 2 == 0 : p % 2 != 0) {
                    ans[p] = i;
                    i++;
                } else {
                    ans[p] = j;
                    j--;
                }
            } else {
                ans[p] = i;
                i++;
            }
        }
        return ans;
    }
}

class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int i = 1, j = n; 
        int p = 0;
        while(i <= j){
            ans[p++] = (k > 1 ? (k-- % 2 != 0 ? i++ : j--) : i++);
        }
        return ans;
    }
}

/**
 * Runtime: 1 ms, faster than 93.22% of Java online submissions for Beautiful
 * Arrangement II.
 * Memory Usage: 42.6 MB, less than 92.09% of Java online submissions for
 * Beautiful Arrangement II.
 */