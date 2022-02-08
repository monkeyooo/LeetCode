package src.main.java;



/*      34. Find First and Last Position of Element in Sorted Array

        Given an array of integers nums sorted in non-decreasing order,
        find the starting and ending position of a given target value.
        If target is not found in the array, return [-1, -1].
        You must write an algorithm with O(log n) runtime complexity.

        Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]

        Example 2:
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]

        Example 3:
        Input: nums = [], target = 0
        Output: [-1,-1]
*/


import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }


    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int minLeftIndex = nums.length - 1;
        int maxRightIndex = 0;
        boolean rightFind = false;
        boolean leftFind = false;
        while (leftPointer <= rightPointer) {
            if (nums[rightPointer] == target) {
                maxRightIndex = Math.max(maxRightIndex, rightPointer);
                res[1] = maxRightIndex;
                rightFind = true;
            }
            if (nums[leftPointer] == target) {
                leftFind = true;
                minLeftIndex = Math.min(minLeftIndex, leftPointer);
                res[0] = minLeftIndex;
            }
            if (!rightFind)
                rightPointer--;
            if (!leftFind)
                leftPointer++;
            if (leftFind && rightFind) break;
        }
        if (leftFind && rightFind)
            return res;
        return new int[]{-1, -1};
    }
}
