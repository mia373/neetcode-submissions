public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        dfs(nums, 0, subset, res);
        
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        //base case: if i is out of bounds
        if (i >= nums.length) {
            //we cannot add subset directly. that just adds a pointer to subset
            //given we keep modifying subset, we should add a copy of subset
            //otherwise, when recursion unbounds, subset becomes an empty list. res would be a list of empty lists
            res.add(new ArrayList<>(subset));
            return;
        }
        
        //decision to include nums[i] (left branch of decision tree)
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);
        
        //decision NOT to include nums[i] (right branch of decision tree)
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, res);
    }
}