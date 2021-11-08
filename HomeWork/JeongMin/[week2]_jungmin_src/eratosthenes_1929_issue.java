import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class eratosthenes_1929_issue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        sieve(start, end);
    }

    public static void sieve(int start, int end) {
        StringBuilder sb = new StringBuilder();

        boolean[] sieve = new boolean[end+1];

        for (int i = start; i <= end; i++) sieve[i] = true;
        sieve[0] = sieve[1] = false;

        for (int i = 2; i <= Math.sqrt(end); i++) {
            for (int j = i; i*j <= end; j++) {
                sieve[i*j] = false;
            }
        }

        for (int i = start; i <= end; i++) {
            if (sieve[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}
