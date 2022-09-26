
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * 203. Remove Linked List Elements
 * Easy
 * 
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 */
class OldSolution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        while (true) {
            if (head.val == val)
                head = head.next;
            else
                break;
            if (head == null)
                break;
        }
        ListNode iter = head;
        while (iter != null) {
            if (iter.next == null)
                break;
            while (iter.next != null) {
                if (iter.next.val == val)
                    iter.next = iter.next.next;
                else
                    break;
            }
            iter = iter.next;
        }
        return head;

    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        ListNode iter = head;
        while (iter != null) {
            while (iter.next != null && iter.next.val == val)
                iter.next = iter.next.next;
            iter = iter.next;
        }
        return head;
    }
}

/**
 * Runtime: 1 ms, faster than 99.00% of Java online submissions for Remove
 * Linked List Elements.
 * Memory Usage: 48.4 MB, less than 83.69% of Java online submissions for Remove
 * Linked List Elements.
 */

// Two pin method
class AnotherSolution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode fast = head, slow = result;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return result.next;
    }
}

// dummmy head
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class BestSolution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode iter = dummyHead;
        while (iter != null && iter.next != null) {
            while (iter.next != null && iter.next.val == val) {
                iter.next = iter.next.next;
            }
            iter = iter.next;
        }
        return dummyHead.next;
    }
}
/**
 * Runtime: 1 ms, faster than 98.97% of Java online submissions for Remove
 * Linked List Elements.
 * Memory Usage: 43.2 MB, less than 89.70% of Java online submissions for Remove
 * Linked List Elements.
 */
