class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //KEY: calculate gas[i] - cost[i]
        //if total sum for gas[i] - cost[i] < 0, there's no valid starting index for the car
        //also, any index with current sum < 0 cannot be the starting point
        //recalculate sum from 0 and move current index to i + 1

        int currGain = 0, totalGain = 0, answer = 0;

        for (int i = 0; i < gas.length; ++i) {
            // gain[i] = gas[i] - cost[i]
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i];

            // If we meet a "valley", start over from the next station
            // with 0 initial gas.
            if (currGain < 0) {
                answer = i + 1;
                currGain = 0;
            }
        }

        return totalGain >= 0 ? answer : -1;
    }
}
