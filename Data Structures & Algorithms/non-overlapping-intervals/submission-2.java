class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        int res = 0; 
        int[] prev= new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int[] interval : intervals) {
            //If current interval's start > newInterval's end, add newInterval to result
            if (interval[0] < prev[1]) {
                res++; 
                if (interval[1] < prev[1]) {
                    prev[0] = interval[0];
                    prev[1] = interval[1]; 
                }
            } else {
                prev[0] = interval[0];
                prev[1] = interval[1]; 
            }            
        }

        return res;
    }
}
