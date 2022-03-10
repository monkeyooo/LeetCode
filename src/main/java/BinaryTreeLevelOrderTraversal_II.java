package src.main.java;
/*Given the root of a binary tree,
return the bottom-up level order traversal of its nodes
 values. (i.e., from left to right, level by level from leaf to root).



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []*/

import java.util.*;

public class BinaryTreeLevelOrderTraversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> subAns = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                subAns.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(0, subAns); // add to head
//            stack.push(subAns);
        }

//        while (!stack.isEmpty()) {
//            ans.add(stack.pop());
//        }

        return ans;
    }

}
