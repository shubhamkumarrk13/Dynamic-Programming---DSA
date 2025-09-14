// Problem Link : https://leetcode.com/problems/longest-increasing-subsequence/

// ************************************* Using Bottom-Up Approach****************

class Solution {
   
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n]; // dp[i] -> longest subsequence till ith index

        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) {

            for(int j=0; j<i; j++) {

                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int result = 0;

        for(int i=0; i<dp.length; i++) {

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
