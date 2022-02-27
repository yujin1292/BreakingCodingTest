import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week15_1743 {

    public static int N, M;
    public static int[] dx = {-1, 1, 0, 0}; // 통로에서 4개 방향으로 움직이기 위해 dx, dy 설정
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] path; // 통로 정보를 저장할 배열
    public static int[][] visited; // 체크한 곳인지 확인
    public static int count;    // 쓰레기 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        path = new int[N][M];
        visited = new int[N][M];

        // 톻로 정보 저장
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            path[x-1][y-1] = 1;
        }

        int result = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 쓰레기가 있는 곳일 경우 bfs로 주변 쓰레기를 파악
                if (visited[i][j] == 0 && path[i][j] == 1) {
                    count = 0;
                    visited[i][j] = 1;
                    bfs(i, j);
                    result = Math.max(result, count);   // 쓰레기 크기 갱신
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[] tmp = {x, y};
        queue.offer(tmp);
        count++;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];  // 현재 X 좌표
            int curY = cur[1];  // 현재 Y 좌표

            // 상하좌우 방향으로 이동
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];   // 다음으로 이동할 X 좌표
                int nextY = curY + dy[i];   // 다음으로 이동할 Y 좌표

                // 다음으로 이동할 좌표가 통로의 범위 내일 때
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    // 다음으로 이동할 좌표에 쓰레기가 있고, 이전에 확인한 적 없는 쓰레기일 때
                    if (path[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                        int[] temp = {nextX, nextY};
                        queue.offer(temp);
                        visited[nextX][nextY] = 1;
                        count++;
                    }
                }
            }
        }
    }
}
