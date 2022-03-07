import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week16_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] T = new int[N+2]; // 1~N까지 사용 & N+1번째에 접근해야 하므로 N+2 크기로 선언
        int[] P = new int[N+2];
        int[] dp = new int[N+2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N; i > 0; i--) {
            int nextIdx = i + T[i]; // i번째 상담으로 T[i]만큼의 시간이 지남
            if (nextIdx - 1 <= N) dp[i] = Math.max(dp[i+1], dp[nextIdx] + P[i]); // i번째 상담을 했을 때 이익을 최대로 할 수 있는지 판단
            else dp[i] = dp[i+1];   // 퇴사 후까지 이어지는 상담은 하지 않음
        }

        System.out.println(dp[1]);
    }
}
