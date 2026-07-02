class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );

        dist[0][0] = grid.get(0).get(0);

        pq.offer(new int[]{0, 0, dist[0][0]});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];

            if (cost > dist[x][y])
                continue;

            for (int[] d : dir) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;

                int newCost = cost + grid.get(nx).get(ny);

                if (newCost < dist[nx][ny]) {

                    dist[nx][ny] = newCost;
                    pq.offer(new int[]{nx, ny, newCost});
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}