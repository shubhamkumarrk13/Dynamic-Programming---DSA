// Problem Link : https://leetcode.com/problems/house-robber/description/

class Solution {

    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1]; // dp[i] = max. stolen money till ith house

        dp[0] = 0;

        dp[1] = nums[0];

        for(int i=2; i<=nums.length; i++) {

            int steal = nums[i - 1] + dp[i - 2];

            int skip = dp[i - 1];

            dp[i] = Math.max(steal, skip);
        }

        return dp[nums.length];
        
    }
}


// // ****************************************** Using Bottom up Approach (Constant Space) *************************

// class Solution {

//     public int rob(int[] nums) {

//         int prevPrev = 0;

//         int prev = 0;

//         for(int i=1; i<=nums.length; i++) {

//             int steal = nums[i - 1] + prevPrev;

//             int skip = prev;

//             int temp = Math.max(steal, skip);

//             prevPrev = prev;

//             prev = temp;
//         }

//         return prev;
        
//     }
// }
