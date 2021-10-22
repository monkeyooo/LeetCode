package src.main.java;

import java.util.*;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 * <p>
 * Return the sorted string. If there are multiple answers, return any of them.
 * <p>
 * Example 1:
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 */

//451. Sort Characters By Frequency
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        //for count map
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // comparator
        PriorityQueue<Character> que = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        que.addAll(map.keySet());
        StringBuilder result = new StringBuilder();
        while (!que.isEmpty()) {
            char c = que.poll();
            result.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
        }
        return result.toString();
    }

}
