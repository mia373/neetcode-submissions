class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int[] topologicalOrder = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder[i++] = node;

            for (int neighbor: adj.get(node)) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }
}
