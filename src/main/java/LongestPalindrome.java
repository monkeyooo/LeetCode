package src.main.java;

import java.util.HashMap;
import java.util.Map;


//409
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean oddFound = false;
        int res = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) oddFound = true;
            res += map.get(c)/2;
        }

        return oddFound ? 2*res + 1 : 2*res;
        // int[] freq = new int[265];
        // for(char ch: s.toCharArray()) freq[ch]++;
        // int ans = 0;
        // boolean flag = false;
        // for(int i: freq) {
        //     ans += i/2;
        //     if(i%2 == 1) flag = true;
        // }
        // return 2*ans + (flag ? 1 : 0);

        // if(s==null || s.length()==0) return 0;
        // Set<Character> set = new HashSet<>();
        // int count = 0;
        // char[] chars = s.toCharArray();
        // for(char c: chars) {
        //     if(set.remove(c)) {
        //         count++;
        //     } else {
        //         set.add(c);
        //     }
        // }
        // return set.isEmpty() ? count*2 : count*2+1;
    }
}
