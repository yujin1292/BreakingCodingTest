import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week14_1806 {
    public static int[] seq;
    public static int N;
    public static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

       seq = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        System.out.println(shortest_seq());
    }

    public static int shortest_seq() {
        int start = 0, end = 0; // 수열의 양끝을 가리킬 인덱스
        int sum = 0;
        int size = 100001;  // 최소 수열의 길이

        while(end <= N) {
            // 합이 S 이상일 때
            if(sum >= S){      
                // 최소 길이를 구함
                size = Math.min(size, end-start);
                sum -= seq[start++];    // 앞쪽 인덱스 이동
            }
            // 합이 S보다 작을 때
            else {
                sum += seq[end++];  // 뒤쪽 인덱스 이동
            }
        }

        // 합이 S 이상인 경우가 없을 때
        if (size == 100001) size = 0;

        return size;
    }
}
