class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int maxProfit = 0; 
        
        for (int i=0; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i]; 
            } else {
                int currentProfit = prices[i] - low;
                maxProfit = Math.max(maxProfit, currentProfit); 
            }
        }

        return maxProfit;
    }
}
