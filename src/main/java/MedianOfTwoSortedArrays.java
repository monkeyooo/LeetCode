package src.main.java;


/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.
Example 2:
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

*/


public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
    }

    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int medianIndex = (num1Length + num2Length) /2;
        boolean isEven = (num1Length + num2Length) % 2 == 0;
        int median1 = 0, median2 = 0;
        int i = 0;
        int index1 = 0;
        int index2 = 0;
        while (i <= medianIndex) {  // (m + n) / 2
            median1 = median2;
            if (index1 == num1Length) {
                median2 = nums2[index2];
                index2++;
            } else if(index2 == num2Length) {
                median2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                median2 = nums1[index1];
                index1++;
            } else {
                median2 = nums2[index2];
                index2++;
            }
            i++;
        }
        if (!isEven) median1 = median2;
        return (double) (median1 + median2) / 2;
    }
}
