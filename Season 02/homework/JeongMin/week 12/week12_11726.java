import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week12_11726 {
    // 다이나믹 프로그래밍을 위한 배열
    // n일 경우의 값을 저장 -> 구하지 않았다면 0
    public static int d[] = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n값 받아오기
        int n = Integer.parseInt(br.readLine());

        System.out.println(dp(n));
    }

    public static int dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (d[n] != 0) return d[n]; // 값을 이미 구했다면 d 배열의 값 반환
        return d[n] = (dp(n-1) + dp(n-2)) % 10007;  // 구하지 않은 값이면 새로 계산
    }
}
