package src.main.java;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{1,2}, 2));
        System.out.println(search(new int[]{1,2}, 0));
        System.out.println(search(new int[]{5, 1, 3}, 3));
        System.out.println(search(new int[]{3, 1}, 1));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        else {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int pivot = (left + right) / 2;
                if (nums[pivot] == target) {
                    return pivot;
                } else if (nums[pivot] >= nums[left]) { // left number is smaller or equals to pivot
                    if (nums[left] <= target && target < nums[pivot]) { // target will be in left <= target < pivot
                        right = pivot - 1;
                    } else { // move left index to pivot + 1
                        left = pivot + 1;
                    }
                } else {
                    if (nums[pivot] < target && target <= nums[right] ) { // target will be in pivot <= target < right
                        left = pivot + 1;
                    } else { // move right index to pivot - 1
                        right = pivot - 1;
                    }
                }
            }
        return -1;
        }


    }


}
