import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week13_1149 {
    public static void main(String[] args) throws IOException {
        final int RED = 0;
        final int GREEN = 1;
        final int BLUE = 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] homes = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            // 빨강, 초록, 파랑으로 칠할 때의 비용을 저장
            homes[i][RED] = Integer.parseInt(st.nextToken());
            homes[i][GREEN] = Integer.parseInt(st.nextToken());
            homes[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            // 현재 집을 빨강으로 칠할 경우
            homes[i][RED] += Math.min(homes[i-1][GREEN], homes[i-1][BLUE]);
            // 현재 집을 초록으로 칠할 경우
            homes[i][GREEN] += Math.min(homes[i-1][RED], homes[i-1][BLUE]);
            // 현재 집을 파랑으로 칠할 경우
            homes[i][BLUE] += Math.min(homes[i-1][RED], homes[i-1][GREEN]);
        }

        // 최소 비용을 구함
        int result = Math.min(homes[n-1][RED], homes[n-1][GREEN]);
        result = Math.min(result, homes[n-1][BLUE]);

        System.out.println(result);
    }
}
