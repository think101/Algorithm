package main.com.think101.leetcode.Patterns.HeapPriorityQueue.TopKFrequentWords;

import java.util.*;

public class Solution {

    class StrCnt {
        private String str;
        private int cnt;

        public StrCnt(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }

        public String getStr() {
            return this.str;
        }

        public int getCnt() {
            return this.cnt;
        }
    }


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnts = new HashMap<>();
        PriorityQueue<StrCnt> pq = new PriorityQueue<>((a, b) -> {
            if(b.getCnt() > a.getCnt()) {
                return 1;
            }
            else if(b.getCnt() < a.getCnt()) {
                return -1;
            }

            return a.getStr().compareTo(b.getStr());
        });

        List<String> res = new ArrayList<>();

        for(String word : words) {
            if(!cnts.containsKey(word)) {
                cnts.put(word, 0);
            }

            cnts.put(word, cnts.get(word) + 1);
        }

        for(String word : cnts.keySet()) {
            pq.add(new StrCnt(word, cnts.get(word)));
        }

        for(int i = 0; i < k; i++) {
            res.add(pq.poll().getStr());
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> res = s.topKFrequent(words, k);
        for(String word : res) {
            System.out.println(word);
        }
    }
}
