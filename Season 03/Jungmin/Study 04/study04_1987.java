import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study04_1987 {

    public static int R, C;
    public static int[][] board;
    public static boolean[] check;  // 지나온 알파벳인지 확인하는 배열

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        check = new boolean[27];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j) - 'A';
            }
        }

        passMaxSpace(0, 0, 1);
        System.out.println(result);
    }

    public static void passMaxSpace(int x, int y, int depth) {

        result = Math.max(result, depth);

        int curX = x;
        int curY = y;

        check[board[x][y]] = true;  // 인덱스 : 알파벳 - 'A' 값, 지나온 알파벳은 값을 true로 변경

        for (int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
                if (!check[board[nextX][nextY]]) {  // 아직 지나가지 않은 알파벳일 경우
                    check[board[nextX][nextY]] = true;
                    passMaxSpace(nextX, nextY, depth + 1);
                    check[board[nextX][nextY]] = false;
                }
            }
        }
    }
}
