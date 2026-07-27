class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        if (n == 1 && edges.length == 0) return true; 
        
        int[] indegree = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            indegree[node]--;
            nodesVisited++;

            for (int neighbor: adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 1) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == n; 
    }
}
