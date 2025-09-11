// Problem Link : https://leetcode.com/problems/house-robber/description/

class Solution {

    public int solve(int ind, int[] nums, int[] dp) {

        if(ind >= nums.length) return 0;

        if(dp[ind] != -1) return dp[ind];

        int steal = nums[ind] + solve(ind + 2, nums, dp);

        int skip = solve(ind + 1, nums, dp);

        return dp[ind] = Math.max(steal, skip);
    }

    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
        
    }
}
