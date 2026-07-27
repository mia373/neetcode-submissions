class Solution {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        int[] dist = new int[length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Set<Integer> visited = new HashSet<>();
        int edges = 0;
        int res = 0;
        int node = 0; 

        while (edges < length - 1) {
            visited.add(node);
            
            int nextNode = -1;

            for (int i = 0; i < length; i++){
                if (visited.contains(i)) continue; 
                
                int currDis = Math.abs(points[i][0] - points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                
                dist[i] = Math.min(dist[i], currDis);
                
                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }

            res += dist[nextNode];
            node = nextNode;
            edges++;
        }

        return res;
    }
}
