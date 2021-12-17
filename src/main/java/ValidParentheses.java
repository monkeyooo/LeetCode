package src.main.java;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("()")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([)]")); // false
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(ch);
            else {
                if (isCharValidParentheses(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }


    public static boolean isCharValidParentheses(char stackChar, char stringChar) {
//        '(', ')', '{', '}', '[' and ']',
        return (stackChar == '(' && stringChar == ')') || (stackChar == '{' && stringChar == '}') ||
                (stackChar == '[' && stringChar == ']');
    }
}
