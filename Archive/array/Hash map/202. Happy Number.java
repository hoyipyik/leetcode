import java.util.HashSet;

/**
 * 202. Happy Number
 * Easy
 * 
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * 
 * Input: n = 2
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 231 - 1
 * 
 */

class Solution {
    public int judge(int m) {
        int sum = 0;
        while (m > 0) {
            sum += (m % 10) * (m % 10);
            m = m / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        var map = new HashSet<Integer>();
        int sum = n;
        while (true) {
            int holder = judge(sum);
            if (map.contains(holder))
                return false;
            map.add(holder);
            sum = holder;
            if (sum == 1)
                break;
        }
        return true;
    }
}

/**
 * Runtime: 3 ms, faster than 49.74% of Java online submissions for Happy
 * Number.
 * Memory Usage: 41.3 MB, less than 44.19% of Java online submissions for Happy
 * Number.
 */