/**
 * 2. Add Two Numbers
 * Medium
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading
 * zeros.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode iter1 = l1;
        ListNode iter2 = l2;
        int holder = 0;
        int tmp = 0;
        while (iter1.next != null && iter2.next != null) {
            tmp = iter2.val;
            iter2.val = (holder + iter1.val + tmp) % 10;
            holder = (holder + iter1.val + tmp) / 10;
            iter2 = iter2.next;
            iter1 = iter1.next;
        }
        tmp = iter2.val;
        iter2.val = (holder + iter1.val + tmp) % 10;
        holder = (holder + iter1.val + tmp) / 10;
        if (iter1.next == null && iter2.next == null) {
            if (holder != 0) {
                ListNode endNode = new ListNode(holder);
                iter2.next = endNode;
                return l2;
            } else
                return l2;
        }

        if (iter2.next == null && iter1.next != null) {
            iter2.next = iter1.next;
        }
        iter2 = iter2.next;

        while (iter2.next != null) {
            tmp = iter2.val;
            iter2.val = (holder + tmp) % 10;
            holder = (holder + tmp) / 10;
            iter2 = iter2.next;
        }
        tmp = iter2.val;
        iter2.val = (holder + tmp) % 10;
        holder = (holder + tmp) / 10;
        if (holder != 0) {
            ListNode endNode = new ListNode(holder);
            iter2.next = endNode;
            return l2;
        }
        return l2;
    }
}

/**
 * Runtime: 3 ms, faster than 81.53% of Java online submissions for Add Two
 * Numbers.
 * Memory Usage: 46.7 MB, less than 84.64% of Java online submissions for Add
 * Two Numbers.
 */