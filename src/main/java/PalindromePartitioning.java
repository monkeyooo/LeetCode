package src.main.java;

import java.util.ArrayList;
import java.util.List;

//131. Palindrome Partitioning
/*Given a string s, partition s such that every substring of the partition is a palindrome.
        Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.



        Example 1:
        Input: s = "aab"
        Output: [["a","a","b"],["aa","b"]]

        Example 2:
        Input: s = "a"
        Output: [["a"]]


        Constraints:
        1 <= s.length <= 16
        s contains only lowercase English letters.*/

public class PalindromePartitioning {


    List<List<String>> res = new ArrayList<>();


    public List<List<String>> partition(String s) {
        List<String> subAns = new ArrayList<>();
        backtracking(subAns, s);
        return res;
    }


    private void backtracking (List<String> subAns, String s) {

        if (s == null || s.length() == 0) {
            res.add(new ArrayList<>(subAns));
            return;
        }


        for (int i = 1; i <= s.length(); i++) {
            String ansStr = s.substring(0, i); // keep cut the string until the base case break
            if (!isPalindrome(ansStr)) {
                continue;
            }
            subAns.add(ansStr);
//            backtracking(subAns, s.substring(i, s.length()));
            backtracking(subAns, s.substring(i));
            subAns.remove(subAns.size() - 1);
        }
    }


    private boolean isPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i < n / 2; i++) {
            if(s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
