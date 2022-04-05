

// 2667번 단지 번호 붙이기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class week21_2667 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N;
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        int complexCnt = 0;
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 구역이 1이고 방문하지 않은 곳이면 bfs 진행
                    int result = bfs(i, j);
                    resultList.add(result);
                    complexCnt++;   // 단지수 증가
                }
            }
        }

        Collections.sort(resultList);   // 오름차순 정렬
        StringBuilder sb = new StringBuilder();
        sb.append(complexCnt).append('\n');
        for (int num : resultList) sb.append(num).append('\n');

        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        int[] temp = {x, y};
        queue.offer(temp);

        int HomeCnt = 1;    // 단지 내의 집 수
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY]) {
                    if (map[nextX][nextY] == 1) {
                        HomeCnt++;
                        int[] tmp = {nextX, nextY};
                        queue.offer(tmp);
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        return HomeCnt;
    }
}
