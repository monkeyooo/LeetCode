package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
        System.out.println(generateParentheses.generateParenthesis(7));
        System.out.println(generateParentheses.generateParenthesis(6));
        System.out.println(generateParentheses.generateParenthesis(9));
        System.out.println(generateParentheses.generateParenthesis(1));
    }

    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack("", 0, 0, n);
        return ans;
    }

    private void backtrack(String parentheses, int right, int left, int n) {
        if (parentheses.length() == n * 2) {
            ans.add(parentheses);
            return;
        }
        if (left < n) {
            backtrack(parentheses + "(", right, left+1, n);
        }
        if (left > right) {
            backtrack(parentheses + ")", right+1, left, n);
        }
    }
}
