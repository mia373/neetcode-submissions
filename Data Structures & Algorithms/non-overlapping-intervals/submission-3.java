class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        int res = 0; 
        int[] prev= new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int[] interval : intervals) {
            //If current interval has overlapping with previous interval
            if (interval[0] < prev[1]) {
                //We should remove one interval
                res++; 
                
                //Keep the interval with smaller end (smaller range) and remove the other
                //We only compare end because we know interval[0] >= prev[0]. That's how the array was sorted
                if (interval[1] < prev[1]) {
                    prev[0] = interval[0];
                    prev[1] = interval[1]; 
                }
            //If no overlapping, update previous interval to current interval
            } else {
                prev[0] = interval[0];
                prev[1] = interval[1]; 
            }            
        }

        return res;
    }
}
