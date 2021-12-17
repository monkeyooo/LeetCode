package src.main.java;


/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two
 * endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container,
 * such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 */
//11. Container With Most Water
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,9,10,11,7}));
    }

    public static int maxArea(int[] height) {
        if (height.length == 2)
            return Math.min(height[0], height[1]);
        else {
            int leftPtr = 0;
            int rightPtr = height.length - 1;
            int maxContains = 0;
            while (leftPtr < rightPtr) {
                if (height[leftPtr] < height[rightPtr]) {
                    maxContains = Math.max(maxContains, height[leftPtr] * (rightPtr - leftPtr));
                    leftPtr++;
                } else {
                    maxContains = Math.max(maxContains, height[rightPtr] * (rightPtr - leftPtr));
                    rightPtr--;
                }
            }
            return maxContains;
        }

    }
}
