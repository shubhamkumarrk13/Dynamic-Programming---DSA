//Problem Link : https://leetcode.com/problems/maximum-alternating-subsequence-sum/

class Solution {

    long dp[][] = new long[100001][2];

    public long solve(int ind, int[] nums, int flag) {

        if(ind >= nums.length) return 0;

        if(dp[ind][flag] != -1) return dp[ind][flag];

        long skip = solve(ind + 1, nums, flag);

        int val = nums[ind];

        if(flag == 0) val = -val; // odd index;

        long take = solve(ind + 1, nums, 1 - flag) + (long)val;

        return dp[ind][flag] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {

        int flag = 1; // 1 -> true and 0 -> false

        for(int i=0; i<dp.length; i++) {

            for(int j=0; j<dp[0].length; j++) {

                dp[i][j] = -1;
            }
        }

        return solve(0, nums, flag);
        
    }
}
