import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week14_1969 {

    public static int N;
    public static int M;
    public static String[] str;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        str = new String[N];
        for (int i = 0; i < N; i++)
            str[i] = br.readLine();

        hamming_Distance();
        System.out.println(sb);
    }

    public static void hamming_Distance() {
        int hd = 0;

        for (int j = 0; j < M; j++) {

            int A = 0, T = 0, G = 0, C = 0;

            for (int i = 0; i < N; i ++) {
                // i번째 문자열의 j번째 알파벳을 체크
                if (str[i].charAt(j) == 'A') A++;
                else if (str[i].charAt(j) == 'T') T++;
                else if (str[i].charAt(j) == 'G') G++;
                else C++;
            }

            // 가장 많이 겹치는 알파벳을 j번째 알파벳으로 설정
            int max = Math.max(C, Math.max(G, Math.max(A, T)));
            // 사전순 출력을 위해 순서는 A -> C -> G -> T
            if (max == A) sb.append('A');
            else if (max == C) sb.append('C');
            else if (max == G) sb.append('G');
            else sb.append('T');

            // hamming distance를 계산
            hd += N - max;
        }

        sb.append('\n').append(hd);
    }
}
