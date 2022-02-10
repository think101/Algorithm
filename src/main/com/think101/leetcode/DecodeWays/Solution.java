package main.com.think101.leetcode.DecodeWays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numDecodings("301"));
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() +1];
        dp[0] = 1;

        if(s.length()==0)
            return 1;
        else if(s.charAt(0) == '0')
            return 0;
        else if(s.length() == 1)
            dp[1] = 1;
        else {
            dp[1] = 1;
            if(s.charAt(0) > '2' && s.charAt(1) == '0')
                dp[2] = 0;
            else if(s.charAt(0)>'2' || (s.charAt(0)=='2' && s.charAt(1)>'6')
                    || s.charAt(1)=='0') {
                dp[2] = 1;
            }
            else
                dp[2] = 2;
        }

        for(int i=3; i<=s.length(); i++) {
            int t = Integer.parseInt(s.substring(i-2, i));
            if(t>=10 && t<=26)
                dp[i] += dp[i-2];

            if(s.charAt(i-1) != '0')
                dp[i] += dp[i-1];
        }

        return dp[s.length()];
    }


    public int numDecodings_TLE(String s) {
        if(s.length()==0)
            return 1;
        else if(s.charAt(0) == '0')
            return 0;
        else if(s.length() == 1)
            return 1;
        else if(s.length() ==2) {
            if(s.charAt(0)>'2' || (s.charAt(0)=='2' && s.charAt(1)>'6')
                    || s.charAt(1)=='0') {
                return 1;
            }
            else
                return 2;
        }

        int i = Integer.parseInt(s.substring(0,2));
        return numDecodings(s.substring(1)) +
                ((i>=10 && i<=26)? numDecodings(s.substring(2)) : 0);
    }
}
