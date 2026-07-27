public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] representative = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < n; i++) {
            representative[i] = i;
            size[i] = 1;
        }
        
        int components = n;
        for (int[] edge : edges) { 
            components -= combine(representative, size, edge[0], edge[1]);
        }

        return components;
    }

    private int find(int[] representative, int vertex) {
        if (vertex == representative[vertex]) {
            return vertex;
        }
        
        return find(representative, representative[vertex]);
    }
    
    private int combine(int[] representative, int[] size, int vertex1, int vertex2) {
        vertex1 = find(representative, vertex1);
        vertex2 = find(representative, vertex2);
        
        if (vertex1 == vertex2) {
            return 0;
        } else {
            if (size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2];
                representative[vertex2] = vertex1;
            } else {
                size[vertex2] += size[vertex1];
                representative[vertex1] = vertex2;
            }
            return 1;
        }
    }
}
