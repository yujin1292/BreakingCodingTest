import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class study03_3055 {

    public static int R, C;
    public static int[][] forest;
    public static int startX, startY;
    public static int desX, desY;
    public static boolean[][] visited;

    public static Queue<int[]> waterQueue = new LinkedList<>();
    public static Queue<int[]> hedgehogQueue = new LinkedList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    private static final int EMPTY = 0;
    private static final int WATER = 1;
    private static final int STONE = 2;
    private static final int HEDGEHOG = 3;
    private static final int DESTINATION = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        forest = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                char s = temp.charAt(j);
                if (s == 'S') {
                    startX = i;
                    startY = j;
                    forest[i][j] = HEDGEHOG;
                    int[] tmp = {i, j};
                    hedgehogQueue.offer(tmp);
                    visited[i][j] = true;
                } else if (s == 'D') {
                    desX = i;
                    desY = j;
                    forest[i][j] = DESTINATION;
                } else if (s == '.') {
                    forest[i][j] = EMPTY;
                } else if (s == '*') {
                    forest[i][j] = WATER;
                    int[] tmp = {i, j};
                    waterQueue.offer(tmp);
                } else if (s == 'X') {
                    forest[i][j] = STONE;
                }
            }
        }

        int result = getMinRunTime();

        if (result != -1) System.out.println(result);
        else System.out.println("KAKTUS");
    }

    public static int getMinRunTime() {

        int second = 0;

        while (true) {

            if (hedgehogQueue.isEmpty()) return -1;

            int wqSize = waterQueue.size();
            int hqSize = hedgehogQueue.size();

            // 물 먼저 채우기
            while (wqSize-- > 0) {
                int[] waterPos = waterQueue.poll();
                int waterX = waterPos[0];
                int waterY = waterPos[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = waterX + dx[i];
                    int nextY = waterY + dy[i];

                    if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
                        if (forest[nextX][nextY] == EMPTY || forest[nextX][nextY] == HEDGEHOG) {
                            forest[nextX][nextY] = WATER;
                            int[] tmp = {nextX, nextY};
                            waterQueue.offer(tmp);
                        }
                    }
                }
            }

            // 고슴도치 이동
            while (hqSize-- > 0) {
                int[] hedgePos = hedgehogQueue.poll();
                int hedgeX = hedgePos[0];
                int hedgeY = hedgePos[1];


                for (int i = 0; i < 4; i++) {
                    int nextX = hedgeX + dx[i];
                    int nextY = hedgeY + dy[i];

                    if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && !visited[nextX][nextY]) {
                        if (forest[nextX][nextY] == DESTINATION)  { // 목적지에 도착했을 경우
                            return second + 1;
                        }

                        if (forest[nextX][nextY] == EMPTY) {
                            forest[nextX][nextY] = HEDGEHOG;
                            forest[hedgeX][hedgeY] = EMPTY;

                            int[] tmp = {nextX, nextY};
                            hedgehogQueue.offer(tmp);
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }

            second++;
        }
    }

}
