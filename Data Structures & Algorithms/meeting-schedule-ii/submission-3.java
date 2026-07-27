/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        //s is the pointer to start time array. e  is the pointer to end time array
        int res = 0, count = 0, s = 0, e = 0;

        //After iterating all start times, we have get the maximum counter
        while (s < n) {
            if (start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
