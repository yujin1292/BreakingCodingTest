import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class study05_2206 {

    public static int N, M;
    public static int[][] map;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                Character c = s.charAt(j);
                map[i][j] = c - '0';
            }
        }

        System.out.println(bfs(0, 0, 0));
    }

    public static int bfs(int x, int y, int isBroken) {

        int result = 0;

        Queue<int[]> queue = new LinkedList<>();

        visited[x][y][isBroken] = true;

        int[] temp = {x, y, isBroken};
        queue.offer(temp);

        while (!queue.isEmpty()) {

            int qsize = queue.size();

            while (qsize-- > 0) {

                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                int curIsBroken = cur[2];

                if (curX == N - 1 && curY == M - 1) {
                    return result + 1;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY][curIsBroken]) {

                        if (map[nextX][nextY] == 0) {   // 벽이 아닌 경우
                            int[] tmp = {nextX, nextY, curIsBroken};
                            queue.offer(tmp);

                            visited[nextX][nextY][curIsBroken] = true;
                        } else {    // 벽인 경우
                            if (curIsBroken == 0) { // 벽을 부술 수 있는 상태라면
                                int[] tmp = {nextX, nextY, 1};
                                queue.offer(tmp);

                                visited[nextX][nextY][1] = true;
                            }
                        }
                    }
                }
            }
            result += 1;
        }

        return -1;
    }
}
