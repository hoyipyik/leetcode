/**
 * 786. K-th Smallest Prime Fraction
 * Medium
 * 
 * You are given a sorted integer array arr containing 1 and prime numbers,
 * where all the integers of arr are unique. You are also given an integer k.
 * 
 * For every i and j where 0 <= i < j < arr.length, we consider the fraction
 * arr[i] / arr[j].
 * 
 * Return the kth smallest fraction considered. Return your answer as an array
 * of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,3,5], k = 3
 * Output: [2,5]
 * Explanation: The fractions to be considered in sorted order are:
 * 1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
 * The third fraction is 2/5.
 * Example 2:
 * 
 * Input: arr = [1,7], k = 1
 * Output: [1,7]
 * 
 * 
 * Constraints:
 * 
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] is a prime number for i > 0.
 * All the numbers of arr are unique and sorted in strictly increasing order.
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 * 
 * 
 * Follow up: Can you solve the problem with better than O(n2) complexity?
 */
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;
        double left = 0;
        double right = 1;
        while (left <= right) {
            int s = 0;
            int m = 1;
            int cnt = 0;
            double mid = (left + right) / 2.0;
            for (int i = 0; i < len; i++) {
                for (int j = len - 1; j >= 0 && arr[i] <= mid * arr[j]; j--) {
                    cnt++;
                    if (arr[i] * m > s * arr[j]) {
                        s = arr[i];
                        m = arr[j];
                    }
                }
            }
            if (cnt == k)
                return new int[] { s, m };
            else if (cnt > k)
                right = mid;
            else
                left = mid;
        }
        return null;
    }
}

/**
 * Runtime: 59 ms, faster than 62.34% of Java online submissions for K-th
 * Smallest Prime Fraction.
 * Memory Usage: 43.1 MB, less than 73.83% of Java online submissions for K-th
 * Smallest Prime Fraction.
 * 
 */