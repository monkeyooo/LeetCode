package src.main.java;


//322. Coin Change
/*You are given an integer array coins representing coins of different denominations and
        an integer amount representing a total amount of money.

        Return the fewest number of coins that you need to make up that amount.
        If that amount of money cannot be made up by any combination of the coins, return -1.

        You may assume that you have an infinite number of each kind of coin.



        Example 1:
        Input: coins = [1,2,5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1

        Example 2:
        Input: coins = [2], amount = 3
        Output: -1

        Example 3:
        Input: coins = [1], amount = 0
        Output: 0*/

import java.util.Arrays;

public class CoinChange {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1]; // store all amount value
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    private int dp (int[] coins, int amount) {

        if (amount == 0) return 0; // base case1 => can be divide
        if (amount < 0) return -1; // base case2 => can't be divide
        if (memo[amount] != -666) return memo[amount]; // prevent duplicate query
        int res = Integer.MAX_VALUE;
        for (int coin : coins) { // recursive each coin
            int subQuestions = dp(coins, amount - coin);
            if (subQuestions < 0) { // can't count, next
                continue;
            }
            res = Math.min(res, subQuestions + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE ? -1 : res); // store the exist value
        return memo[amount];
    }
}
