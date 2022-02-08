package src.main.java;


/*
Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
        */

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        return slideWindow(nums, target);
    }

    private int slideWindow(int[] nums, int target) {
        int windowWide = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int currentSum = 0;

        while (right < nums.length) {
            currentSum += nums[right];
            right++;
            while (currentSum >= target) {
                windowWide = Math.min(windowWide, right - left);
                currentSum -= nums[left];
                left++;
            }
        }
        return windowWide == Integer.MAX_VALUE ? 0 : windowWide;
    }

}
