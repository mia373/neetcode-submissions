class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(candidates, target, subset, 0);

        return res;
    }

    public void backtrack (int[] candidates, int target, List<Integer> subset, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if (target < 0 || i == candidates.length) {
            return; 
        }

        subset.add(candidates[i]);
        backtrack (candidates, target - candidates[i], subset, i + 1);

        subset.remove(subset.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        backtrack (candidates, target, subset, i + 1);
    }
}
