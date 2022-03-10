package src.main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given the root of a binary tree,
return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []*/
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> subAns = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                subAns.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(subAns);
        }
        return ans;
    }

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
}
