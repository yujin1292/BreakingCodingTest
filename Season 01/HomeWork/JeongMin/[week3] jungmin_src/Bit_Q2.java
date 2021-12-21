import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bit_Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = st.nextToken();

        powerSet(arr);
    }

    public static void powerSet(String[] arr) {
        int n = arr.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 1<<n; i++) {
            for(int j = 0; j < n; j++) {
                if((i & (1<<j)) != 0) sb.append(arr[j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
