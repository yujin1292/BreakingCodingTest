import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week7_2178 {
    public static int[] dx = {-1, 1, 0, 0}; // 미로에서 4개 방향으로 움직이기 위해 dx, dy 설정
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] maze; // 미로 정보를 저장할 배열
    public static int[][] visited; // 갔던 길인지 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 값 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        maze = new int[N][M];
        visited = new int[N][M];

        // 미로의 길 정보 받아오기
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = 1;
        bfs(0, 0, N, M);
        System.out.println(maze[N-1][M-1]);
    }

    public static void bfs(int x, int y, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        int[] tmp = {x, y};
        queue.offer(tmp);

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];  // 현재 X 좌표
            int curY = cur[1];  // 현재 Y 좌표

            // 상하좌우 방향으로 이동
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];   // 다음으로 이동할 X 좌표
                int nextY = curY + dy[i];   // 다음으로 이동할 Y 좌표

                // 다음으로 이동할 좌표가 미로의 범위 내일 때
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    // 다음으로 이동할 좌표가 갈 수 있는 길이고, 이전에 간 적 없는 길일 때
                    if (maze[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                        int[] temp = {nextX, nextY};
                        queue.offer(temp);
                        visited[nextX][nextY] = 1;
                        maze[nextX][nextY] = maze[curX][curY] + 1;  // 몇 번 지나왔는지 횟수 저장
                    }
                }
            }
        }
    }
}
