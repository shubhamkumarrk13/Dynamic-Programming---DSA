// Problem Link : https://leetcode.com/problems/house-robber-ii/description/

class Solution {

    public int solve(int ind, int[] nums, int[] dp, int N) {

        if(ind >= N) return 0;

        if(dp[ind] != -1) return dp[ind];

        int stolen = nums[ind] + solve(ind + 2, nums, dp, N);

        int skip = solve(ind + 1, nums, dp, N);

        return dp[ind] = Math.max(stolen, skip);
    }

    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];

        int n = nums.length;

        int[] dp = new int[101];

        Arrays.fill(dp, -1);

        int firstHouseStolen = solve(0, nums, dp, n-1); // First house is stolen, last house cannot be stolen since they are in located circular fashion

        Arrays.fill(dp, -1);

        int firstHouseNotStolen = solve(1, nums, dp, n);

        return Math.max(firstHouseStolen, firstHouseNotStolen);


        
    }
}
