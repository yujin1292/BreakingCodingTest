

// 1562번 계단 수


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week23_1562 {
    public static void main(String[] args) throws IOException {
        int MOD = 1000000000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][][] dpArr = new long[N+1][10][1<<10];
        // dpArr[i][j][k] : i 자리 숫자, j로 끝나는 수, k를 사용한 수

        // 한자리 수는 모두 계단수
        for (int i = 1; i <= 9; i++) dpArr[1][i][1<<i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < (1<<10); k++) {

                    int next = k | (1 << j);

                    // 0으로 끝나는 수일 경우 다음 수는 무조건 1
                    if (j == 0) dpArr[i][j][next] = (dpArr[i][j][next] + dpArr[i-1][j+1][k]) % MOD;

                    // 9로 끝나는 수일 경우 다음 수는 무조건 8
                    else if (j == 9) dpArr[i][j][next] = (dpArr[i][j][next] + dpArr[i-1][j-1][k]) % MOD;

                    else dpArr[i][j][next] = (dpArr[i][j][next] + dpArr[i-1][j+1][k] + dpArr[i-1][j-1][k]) % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) result = (result + dpArr[N][i][(1<<10)-1]) % MOD;


        System.out.println(result);
    }
}
