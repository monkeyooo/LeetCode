package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIV {
    List<Integer> tmp;
    List<List<Integer>> res;

    public static void main(String[] args) {
        CombinationSumIV sumIV = new CombinationSumIV();
        System.out.println(sumIV.combinationSum4(new int[]{4,2,1}, 7));
    }
    public int combinationSum4(int[] nums, int target) {
        tmp = new ArrayList<>();
        res = new ArrayList<>();
        backtracking(nums, target);
        return res.size();
    }

    private void backtracking(int[]nums, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0)
            return;
        for (int num : nums) {
            tmp.add(num);
            backtracking(nums, target - num);
            tmp.remove(tmp.size() - 1);
        }
    }

    private boolean arrayContains(int[]nums, int target) {
        boolean flag = false;
        for (int num : nums) {
            if (num < target) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
