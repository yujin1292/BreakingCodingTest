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
    public static Map<Long, Long> dpArr = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        System.out.println(dp(N));
    }

    public static long dp(long i) {
        if (i == 0) return 1;
        if (dpArr.containsKey(i)) return dpArr.get(i);
        long a = i / P;
        long b = i / Q;
        dpArr.put(i, dp(a) + dp(b));
        return dpArr.get(i);
    }
}
