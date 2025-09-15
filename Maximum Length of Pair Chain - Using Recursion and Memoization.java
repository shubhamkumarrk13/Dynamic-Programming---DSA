// Problem Link : https://leetcode.com/problems/maximum-length-of-pair-chain/description/

class Solution {

    int[][] dp;

    public int solve(int ind, int prev, int[][] pairs) {

        if(ind >= pairs.length) return 0;

        if(prev >= 0 && dp[ind][prev] != -1) return dp[ind][prev];

        int take = 0;

        if(prev == -1 || pairs[prev][1] < pairs[ind][0]) take = 1 + solve(ind + 1, ind, pairs);

        int skip = solve(ind + 1, prev, pairs);

        if(prev >= 0) dp[ind][prev] = Math.max(take, skip);

        return Math.max(take, skip);
    }

    public int findLongestChain(int[][] pairs) {


        dp = new int[1001][1001];

        for(int i=0; i<dp.length; i++) {

            for(int j=0; j<dp[0].length; j++) {

                dp[i][j] = -1;
            }
        }

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        return solve(0, -1, pairs);
        
    }
}
