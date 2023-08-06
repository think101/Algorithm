class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(n, 0, k, new HashSet<>());

        return res;
    }

    private void helper(int n, int curr, int k, Set<Integer> visited) {
        if(k < 0) return;
        if(k == 0) {
            res.add(new ArrayList<>(visited));
            return;
        }

        for(int i = curr + 1; i <= n; i++) {            
            visited.add(i);
            helper(n, curr, k - 1, visited);
            visited.remove(i);
        }
    }
}
