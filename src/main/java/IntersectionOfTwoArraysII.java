package src.main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        System.out.println(intersectionOfTwoArraysII.intersect(new int[]{1,2,2,1}, new int[]{2,2}));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ansList = new ArrayList<>();
        if (nums1.length > nums2.length) {
            for (int j : nums1) {
                if (map.containsKey(j)) {
                    int add = map.get(j) + 1;
                    map.put(j, add);
                } else
                    map.put(j, 1);
            }
            for (int n2 : nums2) {
                if (map.containsKey(n2) && map.get(n2) > 0) {
                    map.put(n2, map.get(n2) - 1);
                    ansList.add(n2);
                }
            }
        } else {
            for (int j : nums2) {
                if (map.containsKey(j)) {
                    int add = map.get(j) + 1;
                    map.put(j, add);
                } else
                    map.put(j, 1);
            }
            for (int n1 : nums1) {
                if (map.containsKey(n1) && map.get(n1) > 0) {
                    map.put(n1, map.get(n1) - 1);
                    ansList.add(n1);
                }
            }
        }

        System.out.println(ansList.toString());

        return ansList.stream().mapToInt(i -> i).toArray();
    }
}
