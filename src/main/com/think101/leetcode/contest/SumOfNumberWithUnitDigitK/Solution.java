class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0)
            return 0;
        
        if(num < k)
            return -1;
        else if(num == k)
            return 1;
        
        int[] dp = new int[11];
        dp[0] = 0;
        int r = num % 10; 
        
        for(int i = 1; i <= 10; i++){
            dp[i] = dp[i-1] + k;
            
            if(dp[i] % 10 == r  && dp[i] <= num) {
                return i;
            }
        }
        
        return -1;
        
    }
}
