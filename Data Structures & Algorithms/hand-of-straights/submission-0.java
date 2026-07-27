public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //Check if the length of the hand array is divisible by groupSize
        if (hand.length % groupSize != 0) return false;
				
				//HashMap to store the count of each card value
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
				
				//Sort the array in order to find the minimal value
        Arrays.sort(hand);
        
        for (int num : hand) {
            //Always start a group with the minimal value (count>0)
            if (count.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                 //i may not be in the map. getOrDefault(i, 0) avoids null issues
                    if (count.getOrDefault(i, 0) == 0) return false;
                    count.put(i, count.get(i) - 1);
                }
            }
        }
        return true;
    }
}