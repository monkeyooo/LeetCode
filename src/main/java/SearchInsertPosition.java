package src.main.java;

/*Given a sorted array of distinct integers and a target value,
return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.


example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
*/

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,2,3,4,5,6}, 1));

        System.out.println(searchInsertPosition.searchInsert(new int[]{1,2,3,4,5,6}, 0));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,2,3,4,5,6}, 5));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,2,3,4,5,6}, 4));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,2,3,4,5,6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // target is smaller/equal than nums[left]
        if (nums[left] >= target) {
            return left;
        }
        // target is between ( nums[left] and nums[right] ]
        else if (nums[right] >= target) {
            return right;
        }
        // target is bigger than nums[right]
        return right + 1;
    }
}
