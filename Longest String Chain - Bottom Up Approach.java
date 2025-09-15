// Problem Link : https://leetcode.com/problems/longest-string-chain/description/

// // *************************************** Using Recursion and Memoization ************************

class Solution {

    public boolean checkPredecessor(String prev, String current) {

        if(current.length() - prev.length() != 1) return false;

        int i = 0;

        int j = 0;

        while(i < prev.length() && j < current.length()) {

            if(prev.charAt(i) == current.charAt(j)) i++;

            j++;
        }

        if(i == prev.length()) return true;

        return false;

    }

    public int longestStrChain(String[] words) {

        int n = words.length;

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int[] dp = new int[n]; // dp[i] -> longest sequence till ith index

        Arrays.fill(dp, 1);

        int result = 1;

        for(int i=0; i<n ; i++) {

            for(int j=0; j<i; j++) {

                if(checkPredecessor(words[j], words[i])) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }
}

