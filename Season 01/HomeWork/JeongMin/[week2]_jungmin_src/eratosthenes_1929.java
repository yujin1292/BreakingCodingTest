import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class eratosthenes_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        sieve(start, end);
    }

    public static void sieve(int start, int end) {
        StringBuilder sb = new StringBuilder();

        for(int i = start; i <= end; i++) {
            if(checkIsPrime(i)) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static boolean checkIsPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num %2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i+=2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
