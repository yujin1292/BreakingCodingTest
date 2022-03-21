import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week18_2064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ip = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            int tmp = 0;
            for (int j = 0; j < 4; j++) {
                int next = Integer.parseInt(st.nextToken());
                tmp <<= 8;
                tmp += next;
            }

            ip[i] = tmp;
        }

        // 주어진 ip 주소들을 비교해서 달라지는 부분을 체크
        // -> 처음부터 달라지는 부분 전까지 1로 채우면 네트워크 마스크
        int mask = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = 1 << i;
            boolean isSame = true;

            for (int j = 1; j < n; j++) {
                if ((ip[0] & bit) != (ip[j] & bit)) {   // 첫번째 ip 주소를 기준으로 비교
                    isSame = false;
                    break;
                }
            }

            if (!isSame) break; // 같지 않다면 break
            else mask |= bit;   // 같다면 1로 채우기
        }

        // 네트워크 주소
        int addr = ip[0] & mask;

        // 8개씩 끊어서 10진수 출력
        StringBuilder sb = new StringBuilder();
        int checkBit = (1<<8)-1;    // 8자리가 1로 채워진 비트
        int shift = 24;
        for (int i = 0; i < 4; i++, shift -= 8) {
            sb.append((addr>>shift)&checkBit);
            if (i != 3) sb.append(".");
        }

        sb.append('\n');
        shift = 24;
        for (int i = 0; i < 4; i++, shift -= 8) {
            sb.append((mask>>shift)&checkBit);
            if (i != 3) sb.append(".");
        }

        System.out.println(sb);
    }
}
