// Problem Link : https://leetcode.com/problems/fibonacci-number/description/

// ************************** Using - DP (Bottom up) *******************

// class Solution {

//     public int fib(int n) {

//         if(n <= 0) return n;

//         int[] dp = new int[n + 1]; // dp[i] = ith Fibonacci number

//         dp[0] = 0;

//         dp[1] = 1;

//         for(int i=2; i<=n; i++) {

//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }
// }

// ************************** Using - DP (Bottom up - Without extra space) *******************

class Solution {

    public int fib(int n) {

       if(n <= 1) return n;

       int a = 0;

       int b = 1;

       for(int i=1; i<=n-1; i++) {

            int c = a + b;

            a = b;

            b = c;
       }

       return b;
    }
}
