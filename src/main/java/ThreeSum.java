package src.main.java;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * Example 2:
 * Input: nums = []
 * Output: []
 * <p>
 * Example 3:
 * Input: nums = [0]
 * Output: []
 */

//15. 3Sum
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        else {
            Arrays.sort(nums);
            //a+b+c = 0
            // two pointers
            //1,2,3,4,5,6
            //flag,frontPtr(2),3,4,5,backPtr(6)
            //flag,2,frontPtr(3),4,5,backPtr(6)
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {// nums.length -2 : for last two pointers
                int flag = -(nums[i]);
                int frontPtr = i + 1;
                int backPtr = nums.length - 1;
                System.out.println(flag);
                if (i == 0 || nums[i] != nums[i - 1]) { // skip same numbers
                    while (frontPtr < backPtr) {
                        int frontVal = nums[frontPtr];
                        int backVal = nums[backPtr];
                        if ((frontVal + backVal) == flag) { // a+b = c
                            ans.add(Arrays.asList(-flag, frontVal, backVal)); // convert negative to positive
                            //if next number is duplicate, skip
                            while (frontPtr < backPtr && nums[frontPtr] == nums[frontPtr + 1]) frontPtr++;
                            //if previous number is duplicate, skip
                            while (frontPtr < backPtr && nums[backPtr] == nums[backPtr - 1]) backPtr--;
                            frontPtr++;
                            backPtr--;
                        }
                        else if (flag > frontVal + backVal) frontPtr++;
                        else backPtr--;
                    }
                }
            }
            return ans;
        }
    }
}
