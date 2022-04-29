import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week24_16236 {

    public static int N;
    public static int[][] space;
    public static int[][] visited;

    public static int sharkX, sharkY;
    public static int minX, minY, minDist;
    public static int sharkSize = 2;

    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        space = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                space[i][j] = tmp;

                // 상어 위치 저장
                if (tmp == 9) {
                    sharkX = i;
                    sharkY = j;
                    space[i][j] = 0;
                }
            }
        }

        int eatCnt = 0;
        int moveDist = 0;

        while(true) {
            minX = minY = 21;
            minDist = 401;

            visited = new int[N][N];

            bfs(sharkX, sharkY);

            // 먹을 수 있는 물고기를 찾았을 때 (minX, minY가 갱신되었을 경우)
            if (minX != 21 && minY != 21) {

                moveDist += visited[minX][minY];
                eatCnt++;

                // 먹은 물고기 수와 상어 크기가 같다면 상어 크기 증가
                if (eatCnt == sharkSize) {
                    sharkSize++;
                    eatCnt = 0;
                }

                space[minX][minY] = 0;

                sharkX = minX;
                sharkY = minY;
            }

            else break;
        }

        System.out.println(moveDist);
    }

    public static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        int[] tmp = {x, y};
        queue.offer(tmp);

        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {

                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 다음 이동할 좌표가 공간 내에 있고
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {

                    // 방문한 적이 없으며 지나갈 수 있는 길일 때
                    if (visited[nextX][nextY] == 0 && space[nextX][nextY] <= sharkSize) {

                        visited[nextX][nextY] = visited[curX][curY] + 1;

                        // 먹을 수 있는 물고기가 있을 경우
                        if (space[nextX][nextY] > 0 && space[nextX][nextY] < sharkSize) {

                            // 가장 가까우면서 가장 위, 왼쪽 좌표를 찾기 위해 minX, minY 값 갱신
                            if (minDist > visited[nextX][nextY]) {
                                minX = nextX;
                                minY = nextY;
                                minDist = visited[nextX][nextY];
                            }

                            else if (minDist == visited[nextX][nextY]) {

                                if (minX == nextX) {
                                    if (minY > nextY) {
                                        minX = nextX;
                                        minY = nextY;
                                    }
                                }
                                else if (minX > nextX) {
                                    minX = nextX;
                                    minY = nextY;
                                }
                            }
                        }

                        int[] temp = {nextX, nextY};
                        queue.offer(temp);
                    }
                }
            }
        }
    }
}
