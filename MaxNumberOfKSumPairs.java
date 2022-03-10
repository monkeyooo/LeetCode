import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        MaxNumberOfKSumPairs maxNumberOfKSumPairs = new MaxNumberOfKSumPairs();
        System.out.println(maxNumberOfKSumPairs.maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println(maxNumberOfKSumPairs.maxOperations(new int[]{3,1,5,1,1,1,1,1,2,2,3,2,2}, 1));
    }

    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int front = 0, back = nums.length - 1;
        while (front < back) {
            if (nums[front] + nums [back] == k) {
                ans++;
                front++;
                back--;
            } else if (nums[front] + nums[back] > k) {
                back--;
            } else front++;
        }

        return ans;
    }
}
