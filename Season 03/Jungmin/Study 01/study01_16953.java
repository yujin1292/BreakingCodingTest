import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study01_16953 {

    public static long A, B;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        result = -1;
        dfs(A, 0);

        System.out.println(result);
    }

    public static void dfs(long num, int depth) {

        if (num > B) {  // 결과값이 B보다 커지면 B를 만들 수 없으므로 -1
            return;
        } else if (num == B) {  // 결과값이 B일 때 depth(연산횟수)를 저장
            result = depth + 1;
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                dfs(num * 2, depth + 1);    // 2를 곱함
            } else {
                String temp = num + "1";    // 수의 뒤에 1을 추가함
                long tmp = Long.parseLong(temp);
                dfs(tmp, depth + 1);
            }
        }
    }
}
