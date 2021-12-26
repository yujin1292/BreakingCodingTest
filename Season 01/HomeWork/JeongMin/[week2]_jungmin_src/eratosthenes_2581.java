import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class eratosthenes_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        sieve(start, end);
    }

    public static void sieve(int start, int end) {
        StringBuilder sb = new StringBuilder();
        int sum = 0, min = 10001;

        for(int i = start; i <= end; i++) {
            if(checkIsPrime(i)) {
                if (min > i) min = i;
                sum += i;
            }
        }

        if (sum == 0) sb.append(-1).append('\n');
        else sb.append(sum).append('\n').append(min).append('\n');

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
