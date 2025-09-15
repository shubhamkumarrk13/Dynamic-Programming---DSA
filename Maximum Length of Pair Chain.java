// Problem Link : https://leetcode.com/problems/maximum-length-of-pair-chain/

// ********************************** USING BOTTOM-UP APPROACH ************************

class Solution {

    public int findLongestChain(int[][] pairs) {

        int n = pairs.length;

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n]; // dp[i] -> Longest sequence till ith index

        Arrays.fill(dp, 1);

        int maxLIS = 1;

        for(int i=0; i<n ; i++) {

            for(int j=0; j<i; j++) {

                if(pairs[i][0] > pairs[j][1]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    maxLIS = Math.max(maxLIS, dp[i]);
                }
            }
        }

        return maxLIS;

    }
}
