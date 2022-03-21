import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class week16_1351 {
    public static long N;
    public static int P;
    public static int Q;
    public static Map<Long, Long> dpArr = new HashMap<>();  // 수의 범위가 크기 때문에 배열 사용 X

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        System.out.println(dp(N));
    }

    // 다이나믹 프로그래밍
    public static long dp(long i) {
        if (i == 0) return 1;
        if (dpArr.containsKey(i)) return dpArr.get(i);  // 존재하는 키(인덱스)라면 그 값을 반환
        long a = i / P; // i/P를 넘지 않는 가장 큰 정수 -> i/P의 몫과 같음
        long b = i / Q;
        dpArr.put(i, dp(a) + dp(b));
        return dpArr.get(i);
    }
}
