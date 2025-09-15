// Problem Link : https://leetcode.com/problems/longest-string-chain/description/

// *************************************** Using Recursion and Memoization ************************

class Solution {

    int[][] dp;

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

    public int solve(int ind, int prev, String[] words) {

        if(ind >= words.length) return 0;

        if(prev != -1 && dp[ind][prev] != -1) return dp[ind][prev];

        int take = 0;

        if(prev == -1 || checkPredecessor(words[prev], words[ind])) take = 1 + solve(ind + 1, ind, words);

        int skip = solve(ind + 1, prev, words);

        if(prev != -1) dp[ind][prev] = Math.max(take, skip);

        return Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {

        dp = new int[1001][1001];

        for(int i=0; i<1001; i++) {

            for(int j=0; j<1001; j++) {

                dp[i][j] = -1;
            }
        }

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        return solve(0, -1, words);
        
    }
}
