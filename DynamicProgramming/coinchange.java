package HackWithInfy2025.DynamicProgramming;

// Problem: Coin Change
// Difficulty: Medium
// Link: https://leetcode.com/problems/coin-change/
class coinchange{
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int dp[] = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}