import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week19_programmersSnail {

    public static int[] dx = {1, 0, -1};    // 아래, 오른쪽, 대각선
    public static int[] dy = {0, 1, -1};
    public static int n = 1;
    public static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        result = new int[n][n];

        Snail();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] != 0) {
                    if (i == n-1 && j == n-1) sb.append(result[i][j]).append("]");
                    else sb.append(result[i][j]).append(",");
                }
            }
        }

        System.out.println(sb);
    }

    public static void Snail() {
        int dir = 0;
        int limit = n*(n+1)/2;  // 결과 배열에 들어갈 총 숫자 개수
        int nextX = 0;
        int nextY = 0;
        int cnt = 1;

        while (cnt <= limit) {
            result[nextX][nextY] = cnt++;

            nextX += dx[dir];
            nextY += dy[dir];

            // 범위 밖이거나 이미 숫자를 채운 곳일 경우
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || result[nextX][nextY] != 0) {
                nextX -= dx[dir];
                nextY -= dy[dir];
                dir++;  // 방향을 바꿈
                dir %= 3;
                nextX += dx[dir];
                nextY += dy[dir];
            }
        }
    }
}
