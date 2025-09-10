// // ********************************* Using Bottom - Up Approach *********************

// class Solution {
    
//     public int climbStairs(int n) {

//         if(n <= 2) return n;

//         int[] dp = new int[n + 1]; // dp[i] = no. of ways to climb ith stair;

//         dp[0] = 0;

//         dp[1] = 1;

//         dp[2] = 2;

//         for(int i=3; i<=n; i++) {

//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
        
//     }
// }

// ********************************* Using Bottom - Up Approach - Without extra space *********************

class Solution {
    
    public int climbStairs(int n) {

        if(n <= 2) return n;

        int a = 1;

        int b = 2;

        for(int i=1; i<=n-2; i++) {

            int c = a + b;

            a = b;

            b = c;
        }

        return b;
    }
}
