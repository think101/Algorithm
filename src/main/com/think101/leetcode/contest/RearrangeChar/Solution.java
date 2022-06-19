class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!sCount.containsKey(s.charAt(i))){
                sCount.put(s.charAt(i), 0);
            }
            
            sCount.put(s.charAt(i), sCount.get(s.charAt(i)) + 1);
        }
        
        for(int i = 0; i < target.length(); i++){
            if(!tCount.containsKey(target.charAt(i))){
                tCount.put(target.charAt(i), 0);
            }
            
            tCount.put(target.charAt(i), tCount.get(target.charAt(i)) + 1);
        }
        int res = Integer.MAX_VALUE;
        for(Character c : tCount.keySet()){
            if(!sCount.containsKey(c)){
                res = 0;
                break;
            }
            
            res = Math.min(res, sCount.get(c) / tCount.get(c));
        }
        
        return res;
        
    }
}
