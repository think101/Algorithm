package main.com.think101.leetcode.CoinChange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        Set<Integer> coinSet = Arrays.stream(coins).boxed().collect(Collectors.toSet());

        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1; i<= amount; i++) {
            if(coinSet.contains(i)) {
                dp[i] = 1;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for(Integer coin : coinSet) {
                if(i-coin > 0 && dp[i-coin] > 0 && dp[i-coin] + 1 < min) {
                    min = dp[i-coin]+1;
                }
            }

            if(min != Integer.MAX_VALUE)
                dp[i] = min;
            else
                dp[i] = -1;
        }

        return dp[amount];

    }
}
