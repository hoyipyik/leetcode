import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * Easy
 * 
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * Example 3:
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
}

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree
 * Preorder Traversal.
 * Memory Usage: 42.8 MB, less than 7.47% of Java online submissions for Binary
 * Tree Preorder Traversal.
 */