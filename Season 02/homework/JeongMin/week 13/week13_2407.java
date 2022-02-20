import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class week13_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // nCm을 계산하기 위해 필요한 값들을 기억할 공간
        BigInteger[][] dp = new BigInteger[101][101];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                // 값이 1일 경우
                if (i == j || j == 0)
                    dp[i][j] = new BigInteger("1");
                // nCr = n-1Cr + n-1Cr-1
                else
                    dp[i][j] = dp[i-1][j].add(dp[i-1][j-1]);
            }
        }

        System.out.println(dp[n][m]);
    }
}
