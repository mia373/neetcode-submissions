class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right =  heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, (right-left)*Math.min(heights[left], heights[right]));
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }
}
