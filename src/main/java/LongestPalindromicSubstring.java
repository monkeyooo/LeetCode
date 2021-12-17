package src.main.java;


/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * Example 3:
 * Input: s = "a"
 * Output: "a"
 * <p>
 * Example 4:
 * Input: s = "ac"
 * Output: "a"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

//5. Longest Palindromic Substring
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbca"));
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String manacherString = "^#";
        for (int i = 0; i < s.length(); i++) {
            manacherString += s.charAt(i) + "#";
        }
        manacherString += "$";
        System.out.println(manacherString);
        int lengthOfManacherStr = manacherString.length();
        int[] radius = new int[lengthOfManacherStr];
        int largestRadiusIndex = 0;
        int largestRadius = 0;
        for (int i = 1; i < lengthOfManacherStr; i++) {
            radius[i] = 0;
            int index = 1;
            while (true) {
                if (i + index > lengthOfManacherStr - 1) break;
                if (i - index < 0) break;
                var prevChar = manacherString.charAt(i + index);
                var nextChar= manacherString.charAt(i - index);
                if (prevChar != nextChar) break;
                radius[i]++;
                System.out.println(radius[i]);
                index++;
            }
            if (largestRadius < radius[i]) {
                largestRadiusIndex = i;
                largestRadius = radius[i];
            }
        }
        return s.substring((largestRadiusIndex - largestRadius)/2, (largestRadiusIndex + largestRadius) / 2);
        /**
         * int n=s.length(),j=0;
         *         char[] str=new char[n*2+3];  // new array to add extra character between each character (including boundries)
         *         int length[]=new int[n*2+3]; // new array to store max length of palindrome after taking each element as center element
         *         str[j++]='$';
         *         for(int i=0;i<n;i++){
         *             str[j++]='#';
         *             str[j++]=s.charAt(i);
         *         }
         *         str[j++]='#';
         *         str[j]='*';
         *         int c=0,r=0,mirror_ind=0,maxlen=0,maxc=0; // maxc and maxlen is center of longest Palindrome and length of longest Palindrome
         *         for(int i=1;i<=n*2+1;i++){
         *             mirror_ind=c-(i-c);
         *             if(i<r)
         *                 length[i]=Math.min(r-i,length[mirror_ind]);
         *             else
         *                 length[i]=0;
         *             while(str[i-length[i]-1]==str[i+length[i]+1])
         *                 length[i]++;
         *             if(i+length[i]>r){
         *                 c=i;
         *                 r=i+length[i];
         *             }
         *             if(length[i]>maxlen){
         *                 maxlen=length[i];
         *                 maxc=c;
         *             }
         *         }
         *         StringBuilder ans=new StringBuilder();
         *         for(int i=maxc-maxlen+1;i<maxlen+maxc;i+=2){
         *             ans.append(str[i]);
         *         }
         *         return ans.toString();
         */
    }
}
