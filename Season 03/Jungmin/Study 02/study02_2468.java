import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class study02_2468 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N;
    public static int[][] area;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        visited = new boolean[N][N];

        int max = -1;
        int min = 101;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, area[i][j]);    // 지역 최대 높이
                min = Math.min(min, area[i][j]);    // 지역 최소 높이
            }
        }

        int maxSafeArea = -1;
        for (int i = min; i <= max; i++) {  // 지역의 최소~최대 높이 사이에서
            maxSafeArea = Math.max(maxSafeArea, countSafeArea(i));  // 최대 안전 지역의 개수를 찾음
        }

        System.out.println(maxSafeArea);
    }

    // 안전한 지역의 개수를 세는 함수
    public static int countSafeArea(int limit) {
        int result = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && area[i][j] >= limit) {    // 방문하지 않은 안전한 지역이 있다면 방문
                    bfs(i, j, limit);
                    result++;   // 안전 지역의 개수 증가
                }
            }
        }

        return result;
    }

    // 안전한 지역을 탐색하는 함수
    public static void bfs(int x, int y, int limit) {
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

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if (!visited[nextX][nextY] && area[nextX][nextY] >= limit) {
                        int[] next = {nextX, nextY};
                        queue.offer(next);
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}

