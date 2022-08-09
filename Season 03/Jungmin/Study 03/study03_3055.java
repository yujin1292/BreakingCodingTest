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
    public static int[][] visited;

    public static Queue<int[]> waterQueue = new LinkedList<>();
    public static Queue<int[]> hedgehogQueue = new LinkedList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int time = 0;
    public static boolean isPossible = false;

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
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                String s = temp.charAt(j) + "";
                if (s.equals("S")) {
                    startX = i;
                    startY = j;
                    forest[i][j] = HEDGEHOG;
                    int[] tmp = {i, j};
                    hedgehogQueue.offer(tmp);
                } else if (s.equals("D")) {
                    desX = i;
                    desY = j;
                    forest[i][j] = DESTINATION;
                } else if (s.equals(".")) {
                    forest[i][j] = EMPTY;
                } else if (s.equals("*")) {
                    forest[i][j] = WATER;
                    int[] tmp = {i, j};
                    waterQueue.offer(tmp);
                } else if (s.equals("X")) {
                    forest[i][j] = STONE;
                }
            }
        }

        getMinRunTime();

        if (isPossible) System.out.println(visited[desX][desY]);
        else System.out.println("KAKTUS");
    }

    public static void getMinRunTime() {

        while (true) {

            if (!waterQueue.isEmpty()) {
                int[] waterPos = waterQueue.poll();
                int waterX = waterPos[0];
                int waterY = waterPos[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = waterX + dx[i];
                    int nextY = waterY + dy[i];

                    if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
                        if (forest[nextX][nextY] == EMPTY) {
                            forest[nextX][nextY] = WATER;
                            int[] tmp = {nextX, nextY};
                            waterQueue.offer(tmp);
                        }
                    }
                }
            }

            if (!hedgehogQueue.isEmpty()) {
                int[] hedgePos = hedgehogQueue.poll();
                int hedgeX = hedgePos[0];
                int hedgeY = hedgePos[1];


                for (int i = 0; i < 4; i++) {
                    int nextX = hedgeX + dx[i];
                    int nextY = hedgeY + dy[i];

                    if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
                        if (forest[nextX][nextY] == DESTINATION)  {
                            visited[nextX][nextY] = visited[hedgeX][hedgeY] + 1;
                            isPossible = true;
                            return;
                        }

                        if (forest[nextX][nextY] == EMPTY) {
                            forest[nextX][nextY] = HEDGEHOG;
                            forest[hedgeX][hedgeY] = EMPTY;

                            int[] tmp = {nextX, nextY};
                            hedgehogQueue.offer(tmp);

                            visited[nextX][nextY] = visited[hedgeX][hedgeY] + 1;
                        }
                    }
                }
            }

            if (waterQueue.isEmpty() && hedgehogQueue.isEmpty()) break;
        }
    }

}
