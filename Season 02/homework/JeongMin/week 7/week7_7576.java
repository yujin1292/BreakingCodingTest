import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week7_7576 {
    // 왼쪽, 오른쪽, 앞, 뒤 토마토에 주는 영향 ->  dx, dy 설정
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] box; // 토마토 박스 정보를 저장할 배열
    public static int[][] visited; // 갔던 길인지 확인
    public static Queue<int[]> queue = new LinkedList<>(); // bfs를 위한 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 값 받기
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 배열 초기화
        box = new int[N][M];
        visited = new int[N][M];

        // 토마토 상태 정보 받아오기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토라면 큐에 저장
                if (box[i][j] == 1) queue.offer(new int[] {i, j});
            }
        }

        bfs(N, M);

        boolean isZero = false; // 0이 있는지 확인
        int result = -1;

        for (int[] tomato: box) {
            for (int t: tomato) {
                if (t == 0) isZero = true; // 익지 않은 토마토가 있을 경우
                else if (t >= result) result = t; // 최대 일수를 result에 저장
            }
        }

        if (result == 1) // 모든 토마토가 이미 익은 상태일 경우
            System.out.println(0);
        else if (isZero) // 모든 토마토가 익지는 못했을 경우
            System.out.println(-1);
        else
            System.out.println(result-1);
    }

    public static void bfs(int N, int M) {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];  // 현재 X 좌표
            int curY = cur[1];  // 현재 Y 좌표

            // 상하좌우 방향으로 이동
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];   // 다음으로 이동할 X 좌표
                int nextY = curY + dy[i];   // 다음으로 이동할 Y 좌표

                // 영향을 줄 수 있는 위치가 박스 내에 있을 때
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    // 영향을 줄 수 있는 위치에 있는 토마토가 익지 않았을 때
                    if (box[nextX][nextY] == 0) {
                        int[] temp = {nextX, nextY};
                        queue.offer(temp);
                        // 며칠이 걸렸는지 계산
                        box[nextX][nextY] = box[curX][curY] + 1;
                    }
                }
            }
        }
    }
}
