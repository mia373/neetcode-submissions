class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] time : times) {
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[]{k, 0});

        Set<Integer> visited = new HashSet<>();

        int minDis = 0; 
        
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[0];
            int dis =curr[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node); 
            minDis = dis; 
            
            if (adj.containsKey(node)) {
                for (int[] edge : adj.get(node)) {
                    int nextNode = edge[0];
                    int nextDis = edge[1];
                    if(!visited.contains(nextNode)) {
                        minHeap.offer(new int[]{nextNode, dis + nextDis}); 
                    }
                }  
            }
        }

        return visited.size() == n ? minDis : -1;
    }
}
