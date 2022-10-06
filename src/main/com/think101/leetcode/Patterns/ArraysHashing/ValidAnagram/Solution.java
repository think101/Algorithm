package main.com.think101.leetcode.Patterns.ArraysHashing.ValidAnagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        for(int i = 0; i < s.length(); i++)
            a[s.charAt(i) - 'a']++;

        for(int j = 0; j < t.length(); j++){
            char c = t.charAt(j);
            a[ c - 'a']--;
            if(a[c - 'a'] < 0)
                return false;
        }

        for(int i = 0; i < 26; i++)
            if(a[i] != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}