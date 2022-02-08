package src.main.java;

        /*
        Given an integer array nums, find the contiguous subarray (containing at least one number)
        which has the largest sum and return its sum.

        A subarray is a contiguous part of an array.

        Example 1:
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.

        Example 2:
        Input: nums = [1]
        Output: 1

        Example 3:
        Input: nums = [5,4,-1,7,8]
        Output: 23
        */

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }


    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int max = nums[0];
        int prev = nums[0];
        for(int i = 1 ; i < nums.length ;i++ ){
//            if(prev + nums[i]  > nums[i]){
//                prev =  prev + nums[i];
//            }else{
//                prev = nums[i];
//            }
            prev = Math.max(prev + nums[i], nums[i]);
            max = Math.max(max , prev);
        }
        return max;
    }
}
