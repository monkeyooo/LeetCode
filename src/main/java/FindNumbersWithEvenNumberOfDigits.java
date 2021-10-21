package src.main.java;

public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>9 && nums[i]<100 || nums[i]>999 && nums[i]<10000 || nums[i]>99999 && nums[i]<100000) ans++;
        }
        return ans;
    }
}
