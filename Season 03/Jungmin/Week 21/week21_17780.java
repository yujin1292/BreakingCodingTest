import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class ChessMan {
    int x;
    int y;
    int dir;

    ChessMan(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public class week21_17780 {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static int N, K;
    public static int[][] map;

    public static ChessMan[] list;
    public static ArrayList<ChessMan>[][] chessManList;

    public static boolean isOver = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ChessMan[K];
        chessManList = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chessManList[i][j] = new ArrayList<ChessMan>();
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int chessX = Integer.parseInt(st.nextToken()) - 1;
            int chessY = Integer.parseInt(st.nextToken()) - 1;
            int chessDir = Integer.parseInt(st.nextToken()) - 1;
            list[i] = new ChessMan(chessX, chessY, chessDir);
            chessManList[chessX][chessY].add(list[i]);
        }

        int turn = 1;
        while (true) {
            if (turn > 1000) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < list.length; i++) {
                ChessMan cur = list[i];

                if (chessManList[cur.x][cur.y].get(0) != cur) continue;

                int nextX = cur.x + dx[cur.dir];
                int nextY = cur.y + dy[cur.dir];

                // 다음칸이 파란색이거나 체스판을 벗어났을 때
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || map[nextX][nextY] == 2) moveToBlue(cur);

                // 다음칸이 흰색일 때
                else if (map[nextX][nextY] == 0) moveToWhite(cur, nextX, nextY);

                // 다음칸이 빨간색일 때
                else if (map[nextX][nextY] == 1) moveToRed(cur, nextX, nextY);

            }

            if (isOver) break;

            turn++;
        }

        System.out.println(turn);
    }

    public static void moveToWhite(ChessMan cur, int nextX, int nextY) {
        ArrayList<ChessMan> curList = chessManList[cur.x][cur.y];

        chessManList[nextX][nextY].addAll(curList);
        curList.clear();

        for (ChessMan c : chessManList[nextX][nextY]) {
            c.x = nextX;
            c.y = nextY;
        }

        if (chessManList[nextX][nextY].size() >= 4) isOver = true;
    }

    public static void moveToRed(ChessMan cur, int nextX, int nextY) {
        ArrayList<ChessMan> curList = chessManList[cur.x][cur.y];

        Collections.reverse(curList);
        chessManList[nextX][nextY].addAll(curList);
        curList.clear();

        for (ChessMan c : chessManList[nextX][nextY]) {
            c.x = nextX;
            c.y = nextY;
        }

        if (chessManList[nextX][nextY].size() >= 4) isOver = true;
    }

    public static void moveToBlue(ChessMan cur) {
        if (cur.dir == 0) cur.dir = 1;
        else if (cur.dir == 1) cur.dir = 0;
        else if (cur.dir == 2) cur.dir = 3;
        else cur.dir = 2;

        int nextX = cur.x + dx[cur.dir];
        int nextY = cur.y + dy[cur.dir];

        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || map[nextX][nextY] == 2) return;
        else if (map[nextX][nextY] == 0) moveToWhite(cur, nextX, nextY);

        // 다음칸이 빨간색일 때
        else if (map[nextX][nextY] == 1) moveToRed(cur, nextX, nextY);
    }
}
