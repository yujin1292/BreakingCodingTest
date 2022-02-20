import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week13_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++)
            seq[i] = Integer.parseInt(st.nextToken());

        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            // 길이를 모두 1로 초기화
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                // 증가수열을 만들 수 있을 때
                if (seq[i] > seq[j] && count[i] < count[j]+1)
                    count[i] = count[j] + 1;
            }
        }

        // 최대값을 찾음
        int result = -1;
        for (int i = 0; i < n; i++)
            result = count[i] > result ? count[i] : result;

        System.out.println(result);
    }
}
