class Solution {

    int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == n - 1 && j == n - 1)
                    continue;

                int best = -1;

                if (i + 1 < n)
                    best = Math.max(best, score[i + 1][j]);

                if (j + 1 < n)
                    best = Math.max(best, score[i][j + 1]);

                if (i + 1 < n && j + 1 < n)
                    best = Math.max(best, score[i + 1][j + 1]);

                if (best == -1)
                    continue;

                int count = 0;

                if (i + 1 < n && score[i + 1][j] == best)
                    count = (count + ways[i + 1][j]) % MOD;

                if (j + 1 < n && score[i][j + 1] == best)
                    count = (count + ways[i][j + 1]) % MOD;

                if (i + 1 < n && j + 1 < n && score[i + 1][j + 1] == best)
                    count = (count + ways[i + 1][j + 1]) % MOD;

                ways[i][j] = count;

                char c = board.get(i).charAt(j);

                if (c == 'S' || c == 'E')
                    score[i][j] = best;
                else
                    score[i][j] = best + (c - '0');
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }
}