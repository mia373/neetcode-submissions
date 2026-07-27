public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //as we're looking for three distinct integers that add up to zero (there may be duplicates in the array), sort the array so that we can apply two pointers algorithm
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
//We can iterate through nums with index i and get nums[i] = -(nums[j] + nums[k]) after rearranging the equation, making -nums[i] = nums[j] + nums[k]
//nums[i] must be a negative number, because nums[j] + nums[k] are on the right and nums[j] + nums[k] must be larger than nums[i]. There's no way they can add up to 0
//stop the for loop when we see a positive nums[i]
            if (nums[i] > 0) break;
//ignore nums[i] if it's duplicative as the previous number           
            if (i > 0 && nums[i] == nums[i - 1]) continue;

//apply two pointers from the right of the i
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
