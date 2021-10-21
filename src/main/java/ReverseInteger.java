package src.main.java;


//7
public class ReverseInteger {
    public int reverse(int x) {
        int positive = 0;
        long tail = 0;
        long temp = 0;
        long ans = 0;
        int i=0;
        if (x == 0) return 0;
        else if (x < 0 ) {
            positive = 1;
            temp = x * -1;
            if (temp > Integer.MAX_VALUE) return 0;
        } else {
            temp = x;
        }

        while (temp!=0){
            tail = temp % 10;
            ans = ans*10 + tail;
            temp = temp/10;
        }
        if (positive > 0) ans = ans*-1;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return 0;
        else {
            return (int) ans;
        }

    }
}
