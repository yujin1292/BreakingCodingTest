import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week15_2775 {

    public static int[][] apt;  // a층 b호에 사는 사람 수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            apt = new int[k+1][n+1];    // 배열 초기화
            sb.append(dp(k, n)).append('\n');
        }

        System.out.println(sb);
    }

    public static int dp(int k, int n) {
        if (k == 0) return n;   // -> 0층의 i호에는 i명이 산다
        if (apt[k][n] != 0) return apt[k][n];   // 이미 계산된 값일 경우
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += dp(k-1, i);  // -> (a-1)층 1호부터 b호까지의 사람들의 수의 합
        }
        return apt[k][n] = ans; // 다이나믹 프로그래밍 구현
        // 처음에 깜빡하고 return ans; 만 했는데 맞았습니다 나오긴 하네여 긁적 머쓱
        // 함수 제목은 dp이지만 dp 안 쓰는 나 (???)
    }
}
