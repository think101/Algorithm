package main.com.think101.leetcode.Grind75.LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }

        int len = s.length();
        String res = "";
        for(int i=0; i<len; i++){
            String subPalinStr = checkPalin(s, i);

            if(subPalinStr.length() > res.length()){
                res = subPalinStr;
            }
        }

        return res;
    }

    private String checkPalin(String s, int i){
        // check palindrom str with i as the center
        StringBuilder sb = new StringBuilder(s.charAt(i));
        int j = 1;
        while(i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j)){
            sb.append(s.charAt(i+j));
            sb.insert(0, s.charAt(i-j));
            j++;
        }
        String sub1 = sb.toString();
        System.out.println(sub1);

        //check palindrom str with space between i and i+1 as the center
        sb = new StringBuilder();
        j = 0;
        while(i-j >= 0 && i+j+1 < s.length() && s.charAt(i-j) == s.charAt(i+j+1)){
            sb.append(s.charAt(i+j+1));
            sb.insert(0, s.charAt(i-j));
            j++;
        }
        String sub2 = sb.toString();
        System.out.println(sub2);

        return sub1.length() > sub2.length() ? sub1 : sub2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "babad";
        System.out.println(s.longestPalindrome(s1));
    }
}
