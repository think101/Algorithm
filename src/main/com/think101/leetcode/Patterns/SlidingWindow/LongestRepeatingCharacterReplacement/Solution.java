package main.com.think101.leetcode.Patterns.SlidingWindow.LongestRepeatingCharacterReplacement;

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCnt = new int[26];
        int l = 0, r = 0;
        int res = 0;
        charCnt[s.charAt(0) - 'A']++;

        while(l < s.length() && r < s.length()) {
            int maxInd = getMaxValueEntry(charCnt);
            int curr = r - l + 1;

            if(curr - charCnt[maxInd] <= k) {
                res = Math.max(res, curr);
                r++;

                if(r < s.length()) {
                    charCnt[s.charAt(r) - 'A']++;
                }
            }
            else {
                l++;

                charCnt[s.charAt(l-1) - 'A']--;
            }
        }

        return res;

    }

    private int getMaxValueEntry(int[] charCnt) {
        int maxIndex = 0;
        for(int i = 0; i < charCnt.length; i++) {
            if(charCnt[i] > charCnt[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
        //System.out.println(solution.characterReplacement("AABABBA", 1));
    }
}