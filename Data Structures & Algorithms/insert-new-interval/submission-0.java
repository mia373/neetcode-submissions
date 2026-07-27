class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            //Given intervals are sorted by starting time without overlapping, we just need to compare if its end time < newInterval's start time
            //If yes, they don't overlap, add the interval to result
            if (newInterval == null || interval[1] < newInterval[0]) {
                res.add(interval);
            //If current interval's start time > newInterval's end time, we found the position to insert newInterval
            //Set newInterval to null after inserted
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            //Otherwise, they have overlapping range. Update the overlapping range for newInterval
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        //If the last interval still overlapps with newInterval, we should make sure insert it before return result
        if (newInterval != null) res.add(newInterval);

        
        return res.toArray(new int[res.size()][]); 
    }
}
