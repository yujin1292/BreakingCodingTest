import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week12_9095 {
    // 다이나믹 프로그래밍을 위한 배열
    // n일 경우의 값을 저장 -> 구하지 않았다면 0
    public static int d[] = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // T값 받아오기
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // n값 받아오기
            int n = Integer.parseInt(br.readLine());
            sb.append(dp(n)).append('\n');
        }

        System.out.println(sb);
    }

    public static int dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (d[n] != 0) return d[n]; // 값을 이미 구했다면 d 배열의 값 반환
        return d[n] = (dp(n-1) + dp(n-2) + dp(n-3));  // 구하지 않은 값이면 새로 계산
    }
}
