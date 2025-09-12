// Problem Link : https://leetcode.com/problems/house-robber-ii/description/

class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp = new int[n + 1]; // dp[i] = amount collected till ith house

        // Case 1 -> stealing first house, we have to skip last house

        int res1 = 0;

        dp[0] = 0;

        for(int i=1; i<=n-1; i++) {

            int skip = dp[i - 1];

            int steal = 0;

            if(i > 1) steal = nums[i - 1] + dp[i - 2];

            else steal = nums[i - 1];

            dp[i] = Math.max(skip, steal);

            res1 = Math.max(res1, dp[i]);
        }

        // Case 2 -> skipping first house and starting stealing from second house

        int res2 = 0;

        Arrays.fill(dp, 0);

        dp[0] = 0;

        dp[1] = 0; // Skipping first house so amount collected till the first house is 0

        for(int i=2; i<=n ; i++) {

            int skip = dp[i - 1];

            int steal = nums[i - 1] + dp[i - 2];

            dp[i] = Math.max(skip, steal);

            res2 = Math.max(res2, dp[i]);
        }

        return Math.max(res1, res2);


    }
}
