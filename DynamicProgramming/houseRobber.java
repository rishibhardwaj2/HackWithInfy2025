package HackWithInfy2025.DynamicProgramming;

public class houseRobber {

    public int rob(int[] nums) {
        int n = nums.length;

        // Edge cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // DP array to store max money at each house
        int[] dp = new int[n];

        dp[0] = nums[0]; // Rob first house
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1]; // Max money that can be robbed
    }

    // Optional: main method to test
    public static void main(String[] args) {
        houseRobber hr = new houseRobber();
        int[] houses = {2, 7, 9, 3, 1};
        int maxMoney = hr.rob(houses);
        System.out.println("Maximum money that can be robbed: " + maxMoney);
    }
}
