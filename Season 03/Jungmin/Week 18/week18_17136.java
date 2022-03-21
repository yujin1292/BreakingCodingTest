import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week18_17136 {

    public static int result = Integer.MAX_VALUE;
    public static int[][] paper;
    public static int[] paperCnt = {0, 5, 5, 5, 5, 5};  // 5종류의 색종이 개수 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        paper = new int[10][10];

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (result == Integer.MAX_VALUE) result = -1;   // 1을 모두 덮을 수 없는 경우

        System.out.println(result);
    }

    public static void dfs(int x, int y, int count) {

        // 마지막 좌표까지 체크했으면 result 갱신
        if (x >= 9 && y > 9) {
            result = Math.min(result, count);
            return;
        }

        // y 좌표가 10이면 다음 줄로 이동
        if (y > 9) {
            dfs(x + 1, 0, count);
            return;
        }

        // 색종이를 붙일 수 있는 구역일 경우
        if (paper[x][y] == 1) {
            for (int i = 5; i > 0; i--) {
                if (paperCnt[i] > 0 && isAttachable(x, y, i)) {
                    attach(x, y, i);
                    paperCnt[i]--;
                    dfs(x, y+1, count+1);
                    detach(x, y, i);
                    paperCnt[i]++;
                }
            }
        } else dfs(x, y+1, count);
    }

    // 현재 좌표에 size 크기의 색종이를 붙일 수 있는지 체크
    public static boolean isAttachable(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // 범위 밖으로 색종이가 나오므로 붙일 수 없음
                if (i < 0 || j < 0 || i > 9 || j > 9) return false;

                if (paper[i][j] == 0) return false;
            }
        }

        return true;
    }

    // 현재 좌표에 size 크기의 색종이를 붙임
    public static void attach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                paper[i][j] = 0;
            }
        }
    }

    // 현재 좌표에 붙어있는 size 크기의 색종이를 뗌
    public static void detach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                paper[i][j] = 1;
            }
        }
    }
}
