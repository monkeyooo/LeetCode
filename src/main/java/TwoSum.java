package src.main.java;

import java.util.HashMap;
import java.util.Map;


//1
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i= 0; i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
