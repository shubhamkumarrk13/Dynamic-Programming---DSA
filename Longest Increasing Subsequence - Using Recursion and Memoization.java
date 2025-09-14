// Problem Link : https://leetcode.com/problems/longest-increasing-subsequence/description/

// ************************************* Using Recusrion and Memoization ****************

class Solution {

    public int solve(int ind, int prevInd, int[] nums, int[][] dp) {

        if(ind >= nums.length) return 0;

        if(prevInd >=0 && dp[ind][prevInd] != -1) return dp[ind][prevInd];

        int take = 0;

        if(prevInd == -1 || nums[ind] > nums[prevInd]) take = 1 + solve(ind + 1, ind, nums, dp);

        int skip = solve(ind + 1, prevInd, nums, dp);

        if(prevInd >= 0) dp[ind][prevInd] = Math.max(take, skip);

        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for(int i=0; i<dp.length; i++) {

            for(int j=0; j<dp[0].length; j++) {

                dp[i][j] = -1;
            }
        }

        return solve(0, -1, nums, dp);
        
    }
}
