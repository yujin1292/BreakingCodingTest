import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week17_13460 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static char[][] toy;
    public static int[][][][] visited;

    public static int N, M;
    public static int holeX, holeY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        toy = new char[N][M];
        visited = new int[N][M][N][M];
        Bead red = new Bead(0, 0, 0);
        Bead blue = new Bead(0, 0, 0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < M; j++) {
                toy[i][j] = tmp.charAt(j);
                if (tmp.charAt(j) == 'R') red = new Bead(i, j, 0);
                if (tmp.charAt(j) == 'B') blue = new Bead(i, j, 0);
                if (tmp.charAt(j) == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }

        System.out.println(bfs(red, blue));
    }

    public static int bfs(Bead red, Bead blue) {
        Queue<Bead> redQueue = new LinkedList<>();
        Queue<Bead> blueQueue = new LinkedList<>();
        redQueue.offer(red);
        blueQueue.offer(blue);

        visited[red.x][red.y][blue.x][blue.y] = 1;

        while(!redQueue.isEmpty() && !blueQueue.isEmpty()) {
            Bead curRed = redQueue.poll();
            Bead curBlue = blueQueue.poll();

            if (curRed.count > 10) return -1;

            // 상하좌우 방향으로 이동
            for(int i = 0; i < 4; i++) {
                int nextRX = curRed.x;
                int nextRY = curRed.y;
                int nextBX = curBlue.x;
                int nextBY = curBlue.y;

                boolean isRedGoal = false;
                boolean isBlueGoal = false;

                while(toy[nextRX+dx[i]][nextRY+dy[i]] != '#') { // 빨간 구슬 벽까지 이동
                    nextRX += dx[i];
                    nextRY += dy[i];

                    if (nextRX == holeX && nextRY == holeY) {   // 구멍일 때
                        isRedGoal = true;
                        break;
                    }
                }

                while(toy[nextBX+dx[i]][nextBY+dy[i]] != '#') { // 파란 구슬 벽까지 이동
                    nextBX += dx[i];
                    nextBY += dy[i];

                    if (nextBX == holeX && nextBY == holeY) {   // 구멍일 때
                        isBlueGoal = true;
                        break;
                    }
                }

                if (isBlueGoal) continue;   // 파란 구슬이 구멍으로 통과

                if (isRedGoal) return curRed.count + 1; // 빨간 구슬이 구멍으로 통과

                if (nextRX == nextBX && nextRY == nextBY) {

                    int dr = Math.abs(nextRX-curRed.x) + Math.abs(nextRY- curRed.y);    // 빨간 구슬 이동 거리
                    int db = Math.abs(nextBX-curBlue.x) + Math.abs(nextBY- curBlue.y);  // 파란 구슬 이동 거리

                    if (dr > db) {
                        nextRX -= dx[i];
                        nextRY -= dy[i];
                    }

                    else {
                        nextBX -= dx[i];
                        nextBY -= dy[i];
                    }
                }

                // 다음에 갈 곳이 방문하지 않은 곳일 때
                if (visited[nextRX][nextRY][nextBX][nextBY] != 0) {
                    visited[nextRX][nextRY][nextBX][nextBY] = 1;
                    redQueue.offer(new Bead(nextRX, nextRY, curRed.count + 1));
                    blueQueue.offer(new Bead(nextBX, nextBY, curBlue.count + 1));
                }
            }
        }

        return -1;
    }
}
