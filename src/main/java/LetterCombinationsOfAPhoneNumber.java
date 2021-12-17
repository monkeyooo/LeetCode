package src.main.java;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() > 4 || digits.length() <= 0) {
            return new ArrayList<>();
        } else {
            Map<Character, List<String>> alphaDigit = new HashMap<>();
            alphaDigit.put('2', Arrays.asList("a", "b", "c"));
            alphaDigit.put('3', Arrays.asList("d", "e", "f"));
            alphaDigit.put('4', Arrays.asList("g", "h", "i"));
            alphaDigit.put('5', Arrays.asList("j", "k", "l"));
            alphaDigit.put('6', Arrays.asList("m", "n", "o"));
            alphaDigit.put('7', Arrays.asList("p", "q", "r", "s"));
            alphaDigit.put('8', Arrays.asList("t", "u", "v"));
            alphaDigit.put('9', Arrays.asList("w", "x", "y", "z"));
            if (digits.length() == 1) {
                return alphaDigit.get(digits.charAt(0));
            }
            Queue<Character> numberQueue = new LinkedList<>();
            for (char c : digits.toCharArray()) {
                numberQueue.add(c);
            }


            List<String> res;
            var number = numberQueue.poll();
            res = new ArrayList<>(alphaDigit.get(number));
            // BFS

            // do bfs until all digits are added.
            while (!numberQueue.isEmpty()) {
                // get current digits
                number = numberQueue.poll();
                // get current letters
                var numberLetters = alphaDigit.get(number); // d, e, f
                List<String> temp = new ArrayList<>();
                for (var numberLetter : numberLetters) {
                    // i = 0 is a, b, c
                    for (String numberBeAdded : res) {
                        numberBeAdded += numberLetter;
                        temp.add(numberBeAdded);
                    }
                }

                res = temp;
            }
            return res;
        }
    }
}
