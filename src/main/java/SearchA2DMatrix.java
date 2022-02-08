package src.main.java;


/*
        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.


        Example 1:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true

        Example 2:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        Output: false
*/

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int rowLen = ints.length;
            if (ints[0] <= target && ints[rowLen - 1] >= target) {
                // in this section
                int left = 0;
                int right = rowLen - 1;
                while (left <= right) {
                    int pivot = left + (right - left) / 2;
                    if (ints[pivot] == target) {
                        return true;
                    }
                    if (ints[pivot] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return false;
    }
}
