public class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();

        backtrack(nums, target, cur, 0);
        
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        //base case 1: we found the combination. add a copy of it to res
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }

        //base case 2: either target or index i is out of bounds. return immediately
        if (target < 0 || i >= nums.length) {
            return;
        }

        //keep adding the same number until we hit the base case
        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);

        //backtrack and add the next number
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }
}
