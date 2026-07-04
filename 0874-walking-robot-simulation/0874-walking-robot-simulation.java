import java.util.HashSet;

class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {

        HashSet<String> set = new HashSet<>();

        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int dir = 0;

        int x = 0;
        int y = 0;

        int maxDistance = 0;

        for (int command : commands) {

            if (command == -1) {

                dir = (dir + 1) % 4;
            }
            else if (command == -2) {

                dir = (dir + 3) % 4;
            }
            else {

                for (int i = 0; i < command; i++) {

                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (set.contains(nx + "," + ny))
                        break;

                    x = nx;
                    y = ny;

                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }
}