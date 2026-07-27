class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Integer> dis = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            if (i == k) {
                dis.put(i, 0);
            } else {
                dis.put(i, Integer.MAX_VALUE);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.add(k);
        
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            visited.add(curr); 

            for (int[] time : times) {
                if (time[0] == curr) {
                    int minDis = Math.min(dis.get(time[1]), time[2] + dis.get(time[0]));
                    dis.put(time[1], minDis); 

                    if (!visited.contains(time[1])) {
                        q.offer(time[1]);
                    }
                }
            }
        }

        int res = 0; 

        for (Integer value : dis.values()) {
            if (value == Integer.MAX_VALUE) {
                return -1;
            }

            res = Math.max(res, value);
        }

        return res; 
    }
}
