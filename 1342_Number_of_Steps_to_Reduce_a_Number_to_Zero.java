//Number of Steps to Reduce a Number to Zero
class Solution {
    public int numberOfSteps (int num) {
        int count=0;
        if(num == 0) return 0;
        else if (num - 1 == 0) return 0;
        while (num != 0){
           if (num%2 == 0){
               count++;
               num = num/2;
            } else {
               count++;
               num = num - 1;
            }
        }
        return count;

    }
}
