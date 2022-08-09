import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study03_15486 {

    public static int N;
    public static int[] time, profit;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        time = new int[N+2];
        profit = new int[N+2];
        dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            int next = i + time[i];
            if (next - 1 <= N) {    // i일의 상담을 할 수 있을 경우
                dp[i] = Math.max(dp[i+1], dp[next] + profit[i]);
            } else {
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);
    }
}
