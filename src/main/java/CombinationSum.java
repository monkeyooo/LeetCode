package src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150
combinations for the given input.


Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
*/


public class CombinationSum {
    List<List<Integer>> res;
    List<Integer> temp;

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7).toString());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        temp = new ArrayList<>();
        res = new ArrayList<>();
        backtracking(candidates, target, 0);
        return res;
    }

    /**
     *
     * @param arr candidates arr
     * @param target target value
     * @param start the start choice index, in order to skip duplicate value
     */
    private void backtracking(int[] arr, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] > target) continue; // skip if the value greater than target
            temp.add(arr[i]);
            backtracking(arr, target - arr[i], i);
            temp.remove(temp.size() - 1);
        }
    }


}
