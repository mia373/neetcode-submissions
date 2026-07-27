class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //the number of nodes was the number of edges - 1. after adding one additional edge, the number of nodes = the number of edges
        //given that the nodes are labeled from 1 to n, the array size should be n + 1 (we're not going to use index 0)
        int[] representative = new int[edges.length + 1];
        int[] size = new int[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            representative[i] = i;
            size[i] = 1;
        }

        //return the edge when the edge creates a cycle
        //Why the Last One? Because the problem states that the initial graph had no cycles and consisted of n−1 edges. 
        //Adding one additional edge creates exactly one cycle. As the code iterates through the edges array, 
        //the redundant edge (the one that creates the cycle) will be the last edge encountered that causes a cycle to be formed. 
        //Any edges processed before the redundant one will successfully unite two previously disconnected components.
        for (int[] edge : edges) {
            if (!combine(representative, size, edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[0];
    }

    private int find (int[]representative, int vertex) {
        if (vertex == representative[vertex]) {
            return vertex;
        }

        return find(representative, representative[vertex]);
    }

    private boolean combine(int[]representative, int[]size, int vertex1, int vertex2) {
        vertex1 = find(representative, vertex1); 
        vertex2 = find(representative, vertex2); 

        if (vertex1 == vertex2) {
            return false;
        } else {
            if (size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2];
                representative[vertex2] = vertex1;
            } else {
                size[vertex2] += size[vertex1];
                representative[vertex1] = vertex2;
            }
            return true; 
        }
    }
}
