

// 16234번 인구이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week20_16234 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N, L, R;
    public static int[][] population;
    public static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int day = 0;
        while(true) {
            boolean isOpen = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for(int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];   // 다음으로 이동할 X 좌표
                        int nextY = j + dy[k];   // 다음으로 이동할 Y 좌표

                        if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                            int diff = Math.abs(population[i][j] - population[nextX][nextY]);
                            if (L <= diff && diff <= R) isOpen = true;
                        }
                    }
                }
            }

            if (!isOpen) break;

            visited = new int[N][N];

            int idx = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) bfs(i, j, idx++);
                }
            }

            day++;
        }

        System.out.println(day);
    }

    public static void bfs(int x, int y, int idx) {
        visited[x][y] = 1;

        Queue<int[]> queue = new LinkedList<>();
        int[] tmp = {x, y};
        queue.offer(tmp);

        int sum = 0;
        int unionNum = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];  // 현재 X 좌표
            int curY = cur[1];  // 현재 Y 좌표
            sum += population[curX][curY];
            System.out.println("curX, curY = " + curX + " " + curY);

            // 상하좌우 방향으로 이동
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];   // 다음으로 이동할 X 좌표
                int nextY = curY + dy[i];   // 다음으로 이동할 Y 좌표
                System.out.println("nextX, nextY = " + nextX + " " + nextY);

                // 다음으로 이동할 좌표가 범위 내일 때
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    // 다음으로 이동할 좌표가 갈 수 있는 길이고, 이전에 간 적 없는 길일 때
                    int diff = Math.abs(population[curX][curY] - population[nextX][nextY]);
                    if (L <= diff && diff <= R && visited[nextX][nextY] == 0) {
                        System.out.println("diff = " + diff);
                        int[] temp = {nextX, nextY};
                        queue.offer(temp);
                        visited[nextX][nextY] = idx;
                        unionNum++;
                    }
                }
            }
        }

        System.out.println("sum, unionNum = " + sum + " " + unionNum);
        int unionPopulation = sum / unionNum;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == idx) population[i][j] = unionPopulation;
            }
        }
    }
}
