class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().orElseThrow(), l = 1; 
        
        while (l <= r) {
            int m = l + (r - l)/2;
            int hours = 0; 
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + m - 1)/m; 
            }
            if (hours <= h) {
                r = m - 1;
            } else{
                l = m + 1;
            }
        }

        return l; 
    }
}
