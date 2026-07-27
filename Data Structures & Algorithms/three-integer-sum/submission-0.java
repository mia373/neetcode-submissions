class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            
            if (i > 0 && nums[i-1] == nums[i]) {
                continue; 
            }

            while (left < right) {
                if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else if (nums[left] + nums[right] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right])); 
                    
                    while (left<right && nums[left] == nums[left+1]) {
                        left++;
                    }

                    while (left<right && nums[right] == nums[right-1]) {
                        right--;
                    }

                    left++; 
                    right--; 
                }
            }
        }

        return res; 
    }
}
