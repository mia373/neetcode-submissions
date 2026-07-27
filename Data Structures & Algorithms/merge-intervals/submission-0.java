class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> res = new ArrayList<>();
        int[] newInterval = new int[]{intervals[0][0], intervals[0][1]};

        for (int[] interval : intervals) {
            //If current interval's start > newInterval's end, add newInterval to result
            if (interval[0] > newInterval[1]) {
                res.add(newInterval);

                //Create a new array every time after we add it. Otherwise, we will update the old array already added
                newInterval = new int[]{interval[0], interval[1]};
            } else {
                //Only need to update the ending number
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }            
        }

        //Don’t forget to add the final newInterval to the result after the loop, since it might not be added if it didn't split
        res.add(newInterval);

        return res.toArray(new int[res.size()][]); 
    }
}
