class Solution {
    public boolean canWinNim(int n) {
        return helper(n-1) || helper(n-2) || helper(n-3);
    }
    
    private boolean helper(int n) {
        return n >= 0 && (n % 4 == 0);
    }
}
