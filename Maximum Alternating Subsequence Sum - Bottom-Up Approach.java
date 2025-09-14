// Problem Link : https://leetcode.com/problems/maximum-alternating-subsequence-sum/

// *************************************** USING BOTTOM-UP APPROACH ***********************

class Solution {

    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;

        long[][] dp = new long[n + 1][2]; // dp[i][0] -> odd length and dp[i][1] -> even length

        for(int i=1; i<=n ;i++) {

            dp[i][0] = Math.max(dp[i - 1][1] + nums[i - 1], dp[i - 1][0]); // odd length

            dp[i][1] = Math.max(dp[i - 1][0] - nums[i - 1], dp[i - 1][1]); // even length
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}
