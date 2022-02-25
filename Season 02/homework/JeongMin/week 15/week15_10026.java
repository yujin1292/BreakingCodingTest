import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class week15_10026 {

    public static int N;
    public static int[] dx = {-1, 1, 0, 0}; // 통로에서 4개 방향으로 움직이기 위해 dx, dy 설정
    public static int[] dy = {0, 0, -1, 1};
    public static char[][] RGB; // 그림 정보를 저장할 배열 (적록색약이 아닐 경우)
    public static char[][] BlindRGB; // 그림 정보를 저장할 배열 (적록색약일 경우)
    public static int[][] visited; // 체크한 곳인지 확인
    public static int count;    // 구역 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        RGB = new char[N][N];
        BlindRGB = new char[N][N];
        visited = new int[N][N];

        // 그림 정보 저장
        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == 'G') BlindRGB[i][j] = 'R';
                else BlindRGB[i][j] = tmp.charAt(j);
                RGB[i][j] = tmp.charAt(j);
            }

        }

        // 적록색약이 아닐 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 체크한 구역이 아닐 때
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    bfs(i, j, RGB);
                    count++;
                }
            }
        }

        sb.append(count).append(" ");
        count = 0;
        visited = new int[N][N];

        // 적록색약일 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 체크한 구역이 아닐 때
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    bfs(i, j, BlindRGB);
                    count++;
                }
            }
        }
        sb.append(count);

        System.out.println(sb);
    }

    public static void bfs(int x, int y, char[][] arr) {
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

                // 다음으로 이동할 좌표가 그림의 범위 내일 때
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    // 다음으로 이동할 좌표의 RGB 값이 현재 좌표의 RGB 값과 같고,
                    // 이전에 확인한 적 없는 좌표일 때
                    if (arr[nextX][nextY] == arr[curX][curY] && visited[nextX][nextY] == 0) {
                        int[] temp = {nextX, nextY};
                        queue.offer(temp);
                        visited[nextX][nextY] = 1;
                    }
                }
            }
        }
    }
}
