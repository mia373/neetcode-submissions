class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Build the adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] time : times) {
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        
        //Build the minHeap that sorts distance between source node and current node in the ascending order
        //So that it always polls the node with the shortest distance
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[]{0, k});

        //Build a hashset to avoid cycle
        Set<Integer> visited = new HashSet<>();

        int minDis = 0; 
        
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[1];
            int dis =curr[0];

            //If we have visited the node before, skip the loop
            if (visited.contains(node)) {
                continue;
            }

            visited.add(node); 
            
            //KEY POINT: the minimum distance is the distance when we poll the last node
            minDis = dis; 
            
            //containsKey avoids null pointer error
            if (adj.containsKey(node)) {
                //find its neighbors
                for (int[] edge : adj.get(node)) {
                    int nextNode = edge[0];
                    int nextDis = edge[1];
                    //If we have not visited the neighbor before, it means we now find the shortest path to the neighbor
                    //Add the neighbor and distance to minHeap
                    if(!visited.contains(nextNode)) {
                        minHeap.offer(new int[]{dis + nextDis, nextNode}); 
                    }
                }  
            }
        }
        
        //return -1 if we didn't visit every node
        return visited.size() == n ? minDis : -1;
    }
}
