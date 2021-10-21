package src.main.java;


/**
 * A decimal number is called deci-binary if each of its digits is either 0 or 1
 * without any leading zeros. For example,
 * 101 and 1100 are deci-binary, while 112 and 3001 are not.
 *
 * Given a string n that represents a positive decimal integer,
 * return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = "32"
 * Output: 3
 * Explanation: 10 + 11 + 11 = 32
 * Example 2:
 *
 * Input: n = "82734"
 * Output: 8
 * Example 3:
 *
 * Input: n = "27346209830709182346"
 * Output: 9
 *
 *
 *
 * We can observe that since we only have deci-binary (1s and 0s) to sum up to given number n,
 * we need atleast n[i] deci-binary numbers to sum up to n[i], where n[i] is the ith digit of given number.
 * 1. Consider n="9"
 * => We need to add 1 for 9 times to get n
 * 2. n = "4201"
 * => We can add    1101
 *                + 1100
 *                + 1000
 *                + 1000
 *               -------
 * 			        4201
 *
 * Notice how we require atleast MAX_DIGIT number of deci-binary numbers,
 * where MAX_DIGIT is max digit in n.
 * So, we only need to find the maximum digit in the given number n and
 * that would be the minimum number of deci-binary numbers required.
 */

//1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static void main(String[] args) {
        // test cases
        minPartitions("32");
    }
    public static int minPartitions(String n) {
        return n.chars().max().getAsInt() - '0';
    }
}
