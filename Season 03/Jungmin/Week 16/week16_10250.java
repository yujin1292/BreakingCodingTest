import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week16_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


            int floor, num;
            // N이 H의 배수일 경우 (건물의 제일 위층)
            if (N % H == 0) {
                floor = H;
                num = N / H;
            }
            // N이 H의 배수가 아닐 경우
            else {
                floor = N % H;
                num = N / H + 1;
            }

            String result = "";
            if (num < 10) result = floor + "0" + num;
            else result = floor + "" + num;

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
