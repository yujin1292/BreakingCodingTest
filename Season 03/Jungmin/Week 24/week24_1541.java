import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week24_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 덧셈 기호 먼저 계산 후 모두 빼기

        // 뺄셈 기호를 기준으로 파싱
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");

        int result = Integer.MAX_VALUE;

        while (st1.hasMoreTokens()) {

            // 덧셈 기호를 기준으로 파싱
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");

            int tmp = 0;
            while (st2.hasMoreTokens()) tmp += Integer.parseInt(st2.nextToken());

            if (result == Integer.MAX_VALUE) result = tmp;
            else result -= tmp;
        }

        System.out.println(result);
    }
}
