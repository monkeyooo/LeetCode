package src.main.java;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

n = 3
1     5      9      13
2  4  6  8  10  12  14
3     7     11
mid = 3/2 = 1
3 + 1 = 4
14 / 4 = 3

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I      N
A   L S    I G
Y A   H  R
P     I
n = 4
1        7          13
2     6  8      12  14
3  5     9  11
4       10

mid num = 4/2 = 2
total char = 14
4 + 2 = 6
14 / 6 = 2


Example 3:
Input: s = "A", numRows = 1
Output: "A"
*/

public class ZigzagConversion {

    public static void main(String[] args) {
        //"PAYPALISHIRING"
        //3
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }


    public static String convert(String s, int numRows) {
        int middleChars = numRows / 2;
        int strLength = s.length();

        int fullColumns = strLength / (middleChars + numRows);
        int i  = 0;
        int indexCol = 0;
        int indexMiddle = 0;
        while (i < strLength) {


            i++;
        }


        return s;
    }
}
