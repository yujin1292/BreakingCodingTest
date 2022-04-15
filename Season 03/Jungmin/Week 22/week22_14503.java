

// 14503번 로봇 청소기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week22_14503 {

    public static int N, M;
    public static int[][] floor;

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};

    public static int[] backX = {1, 0, -1, 0};
    public static int[] backY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        floor = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());
        int curDir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                floor[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int stepA = 0;  // 2a 단계가 4번 연속 진행되었는지 확인하는 변수
        int cleaned = 0;    // 청소한 구역 수
        boolean isStop = true;
        while(isStop) {

            if (stepA != 4) {

                // 현재 위치를 청소
                if (floor[curX][curY] == 0) {
                    floor[curX][curY] = 2;
                    cleaned++;
                }

                // 바로 왼쪽 바닥 좌표
                int nextX = curX + dx[curDir];
                int nextY = curY + dy[curDir];
                
                // 바로 왼쪽에 청소하지 않은 공간이 존재할 경우
                if (floor[nextX][nextY] == 0) {
                    // 왼쪽 방향으로 회전
                    if (curDir == 0) curDir = 3;
                    else curDir--;

                    // 한 칸 전진
                    curX = nextX;
                    curY = nextY;
                    stepA = 0;
                }
                
                // 왼쪽이 벽이거나 청소한 바닥일 경우
                else {
                    // 왼쪽 방향으로 회전
                    if (curDir == 0) curDir = 3;
                    else curDir--;
                    stepA++;
                }
            }

            // 2a번 단계가 연속으로 네번 실행되었을 경우
            else {
                // 바로 뒤쪽이 벽이면 작동을 멈춤
                if (floor[curX + backX[curDir]][curY  + backY[curDir]] == 1) isStop = false;

                // 벽이 아니면 후진
                else {
                    curX = curX + backX[curDir];
                    curY = curY + backY[curDir];
                    stepA = 0;
                }

            }
        }

        System.out.println(cleaned);
    }
}
