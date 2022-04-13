import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week21_2302 {

    public static int N, M;
    public static int[] fixed;
    public static int[] dpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        fixed = new int[M];
        for (int i = 0; i < M; i++) fixed[i] = Integer.parseInt(br.readLine());

        dpArr = new int[N+1];
        dpArr[0] = dpArr[1] = 1;
        dpArr[2] = 2;

        for (int i = 3; i <= N; i++) dpArr[i] = dpArr[i-1] + dpArr[i-2];    // vip 좌석이 없을 경우 앉는 경우의 수

        int start = 0;
        int result = 1;
        for (int i = 0; i < M; i++) {
            int cur = fixed[i];
            result *= dpArr[cur - start - 1];   // vip 좌석으로 나눠지는 구역들에서 앉을 수 있는 경우의 수를 곱함
            start = cur;
        }

        result *= dpArr[N - start]; // 끝좌석에서부터 마지막 vip 좌석까지의 구역

        System.out.println(result);
    }

//    public static int dp(int i) {
//
//        if (i == 1) return 1;
//
//        if (i == 2 && fixed.size() > 0) return 1;
//        if (i == 2 && fixed.size() == 0) return 2;
//
//        if (dpArr[i] != 0) return dpArr[i];
//
//        if (fixed.contains(i) || fixed.contains(i-1)) return dpArr[i] = dp(i-1);
//        else return dpArr[i] = dp(i-1) + dp(i-2);
//    }
}
