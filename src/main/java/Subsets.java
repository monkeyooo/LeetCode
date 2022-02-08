package src.main.java;

import java.util.ArrayList;
import java.util.List;

//78. Subsets
/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
*/

public class Subsets {

    List<List<Integer>> ans;
    List<Integer> tmp;

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}).toString());
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        tmp = new ArrayList<>();
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[]nums, int start) {
        ans.add(new ArrayList<>(tmp));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
