import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study02_14728 {

    public static int N, T;
    public static int[] time, score;
    public static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        time = new int[101];
        score = new int[101];
        result = new int[101][10001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(calculateMaxScore(0,0));
    }

    public static int calculateMaxScore(int curIdx, int curTime) {
        if (curIdx == N) return 0;  // 단원 개수 제한

        if (result[curIdx][curTime] != 0) return result[curIdx][curTime];

        int next = -1;
        if (curTime + time[curIdx] <= T) {  // curIdx번째 단원을 공부할 시간이 있다면
            next = score[curIdx] + calculateMaxScore(curIdx + 1, curTime + time[curIdx]);
        }

        // curIdx번째 단원은 공부할 수 없을 경우
        next = Math.max(next, calculateMaxScore(curIdx + 1, curTime));

        return result[curIdx][curTime] = next;
    }
}
