

// 1012번 유기농 배추

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week22_1012 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int M, N, K;
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[x][y] = 1;

            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) { // 새로운 배추 구역일 경우 bfs 탐색 + 배추흰지렁이 수 증가
                        bfs(i, j);
                        result++;
                    }
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        int[] temp = {x, y};
        queue.offer(temp);

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 주변에 배추가 있다면 큐에 삽입
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY]) {
                    if (map[nextX][nextY] == 1) {
                        int[] tmp = {nextX, nextY};
                        queue.offer(tmp);
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
