import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week24_2156 {

    public static int n;
    public static int[] wine, dpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        wine = new int[10001];
        dpArr = new int[10001];

        for (int i = 1; i <= n; i++) wine[i] = Integer.parseInt(br.readLine());

        dpArr[1] = wine[1];
        dpArr[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            // i번째 와인을 마시는 것이 최솟값이 아닐 수도 있음 -> i-1번째와 비교
            dpArr[i] = Math.max(Math.max(dpArr[i-3] + wine[i-1], dpArr[i-2]) + wine[i], dpArr[i-1]);
        }

        System.out.println(dpArr[n]);
    }
}
