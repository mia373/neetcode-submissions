class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stone: stones) {
            minHeap.offer(-stone);
        }

        while (minHeap.size() > 1) {
            int x = minHeap.poll();
            int y = minHeap.poll();

            if (x < y) {
                x = x - y;
                minHeap.offer(x);
            } else if (x > y) {
                y = y - x;
                minHeap.offer(y);
            } else {
                continue;
            }
        }

        if (minHeap.size() == 1) return Math.abs(minHeap.poll());

        return 0; 
    }
}
