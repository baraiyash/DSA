class Solution {

    List<int[]>[] graph;
    boolean[] visited;
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] road : roads) {

            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        visited = new boolean[n + 1];

        dfs(1);

        return ans;
    }

    void dfs(int node) {

        visited[node] = true;

        for (int[] next : graph[node]) {

            ans = Math.min(ans, next[1]);

            if (!visited[next[0]]) {
                dfs(next[0]);
            }
        }
    }
}